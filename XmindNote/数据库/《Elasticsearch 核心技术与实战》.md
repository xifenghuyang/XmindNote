# 《Elasticsearch 核心技术与实战》

- Github 地址 https://github.com/onebirdrocks/geektime-ELK/

- 极客时间：《Elasticsearch核心技术与实战》视频课程购买地址 - https://time.geekbang.org/course/intro/197

- elasticsearch认证

  认证总结 https://elasticsearch.cn/article/6133

## 第一部分：初识 Elasticsearch

### 第 1 章：概述

1. 课程介绍

2. 课程综述及学习建议

3. Elasticsearch 简介及其发展历史

   >  基于Lucen

   >  Restful API--9200 ;  Transport API--9300

   >  JDBC & ODBC

   功能：

   1. 海量数据分布式存储和集群管理——服务和数据高可用、水平扩展
   2. 近实时搜索——结构化、全文、自动完成
   3. 近实时分析——聚合功能

   

4. Elastic Stack 家族成员及其应用场景

   1. logstash 2009 数据采集和转换
   2. Kibana 奇异果Kiwifruit+Banana 可视化分析
   3. Beats 轻量级数据采集器Go语言实现

### 第 2 章：安装上手

1. Elasticsearch 的安装与简单配置

   下载

   解压

   添加操作用户，并赋予文件夹管理权限

   ```  shell
   chmod -R +777 ./
   ```

   修改conf/jvm.options

   ```shell
   -Xms XG
   -Xmx XG
   ```

   修改elasticsearch.yml

   ```yml
   // 允许局域网访问
   network.host: 0.0.0.0
   // 单节点启动
   discovery.type: single-node
   ```

   查看和安装插件

   ```shell
   // 查看插件
   ./bin/elasticsearch-plugin list
   // 安装国际化分词插件
   ./bin/elasticsearch-plugin install analysis-icu
   ```

   elasticsearch 多实例启动

   ./bin/elasticsearch -E node.name=node1 -E cluster.name=elasticsearch -E path.data=node1-data -d

2. Kibana 的安装与界面快速浏览

   修改./conf/kibana.yml

   ```yml
   server.host: "0.0.0.0"
   ```

   插件安装和查看和elasticsearch一样

   ```
   curl -XGET "http://localhost:9200/_search" -H 'Content-Type: application/json' -d'{  "query": {    "match_all": {}  }}'
   ```

3. 在 Docker 容器中运行 Elasticsearch，Kibana 和 Cerebro

   docker 

   Cerebro  查看集群状态、节点、节点中的角色

4. Logstash 安装与导入数据、

### 第 3 章：Elasticsearch 入门

1. ##### 基本概念（1）：索引，文档和 REST API

2. ##### 基本概念（2）：节点，集群，分片及副本

   master 节点才有权利修改集群状态

   Data Node 负责保存分配数据，保存数据，数据扩展

   Coordinating Node （协调）

   ​	负责接受Client请求，将请求分发到合适的节点，最终把结果汇聚到一起

   ​	每个节点默认都起到了Coordinating Node的职责

   Hot & Warm Node 冷热节点

   ​	Hot 热数据

   Machine Learning Node

   ​	跑机器学期的Job，自动发现异常

   Tribe Node （部落）

   

   开发环境中一个节点可以承担多种角色；

   生产环境中，应该设置单一的角色节点dedicated node （专用）

   | 节点类型               | 配置参数    | 默认值                   |
   | ---------------------- | ----------- | ------------------------ |
   | master eligible (合格) | node.master | true                     |
   | data                   | node.data   | true                     |
   | ingest (摄取)          | node.ingest | true                     |
   | coordinating only      | 无          | 默认是                   |
   | maching learning       | node.ml     | true (配合enable x-pack) |

   ### 分片 primary shard & Replica shard

   主分片：解决水平扩展问题，通过主分片将数据分布到集群内的所有节点上

   ​	一个主分片是一个运行的Lucene实例

   ​	主分片树在索引创建时指定，后续不能修改，除非用Reindex

   副本：解决高可用问题，主分片拷贝。节点出问题时，防丢失

   ​	副本分片数，可动态调整

   ​	增加副本数，可以提高服务可用性，（读取的吞吐）

   分片设定：

   ​	分片过小，后续无法增加节点实现水平扩展，单个分片数据量太大，导致数据重新分配耗时。

   ​	分配过大，over-sharding，影响搜索结果的相关性打分，准确性，单个节点过多分片资源浪费费，影响性能。

   ​	7.0之后主分片默认设置为1

   ```javascript
   // 查看集群健康状况
   GET _cluster/health
   // 查看索引和分片状况
   GET /_cat/nodes
   GET _cat/shards
   ```

   ​	Green：主 副分片正常

   ​	Yellow：主分片正常，副分片部分正常

   ​	Red：有主分片无法正常分配（如，当磁盘容量超过85%时，去创建了一个新的索引）

3. ##### 文档的基本 CRUD 与批量操作

   create： post 自动生成id； put 指定id，若存在则失败

   ```json
   // create,自动生成id
   POST /users/_doc
   {
     "user": "Yang",
     "post_date": "2010-10-11T15:16:17",
     "message": "trying out kibana"
   }
   // create ,指定id。如果id已存在，报错
   PUT users/_doc/1?op_type=create
   {
      "user":"Jack",
      "post_date": "2010-10-11T15:16:17",
      "message": "trying out kibana"
   }
   ```

   Get：/index/_doc/1

   ```
   GET users/_doc/1
   ```

   index: 与create区别。如果文档不存在，就创建新的索引文档；

   ​	旧文档存在，旧文档整挡删除，写入新记录，版本信息+1

   ```json
   PUT users/_doc/1
   {
     "user":"jack2"
   }
   ```

   update：（post形式）请求体中指明doc。数据字段更新。<font color=red> 用于字段增删 </font>

   ```json
   POST users/_update/1
   {
     "doc":{
       "name3":"firstName",
       "name4":"secondName"
     }
   }
   ```

   Bulk API  <font color= red>批处理</font>

   ​	一次rest请求，支持多次不同操作

   ​	index、create、Update、delete

   ​	单条操作出错，不影响其他操作

   ```json
   POST _bulk
   {"index":{"_index":"test", "_id":"1" }}
   {"field11":"value11"}
   {"delete":{"_index":"test","_id":"2"}}
   { "create":{"_index":"test2","_id":"3"}}
   { "field11":"value33"}
   { "update":{"_id":"1","_index":"test"}}
   {"doc":{"field55":"value55"}}
   ```

   mget <font color=red>批量读取</font>

   ```json
   GET _mget
   {
   	"docs":[
   		{
   			"_index":"test",
   			"_id":"1"
   		},{
   			"_index":"test2",
   			"_id":"2"
   		}
   	]
   }
   ```

   msearch <font color=red>批量查询</font>

   ```json
   POST users/_msearch   // 包含3个查询操作
   {}
   {"query":{"match_all":{}},"from":0, "size":10}
   {}
   {"query":{"match_all":{}}}
   {"index":"twitter2"}
   {"query":{"match_all":{}}}
   ```

   常见错误码

   | 问题         | 原因               |
   | ------------ | ------------------ |
   | 无法连接     | 网络故障、集群挂了 |
   | 连接无法关闭 | 网络故障、节点出错 |
   | 429          | 集群过于繁忙       |
   | 4XX          | 请求体格式错误     |
   | 500          | 集群内部错误       |

4. 倒排索引入门

   正排索引：目录页

   ​	文档ID ==> 文档内容、单词的关联

   倒排索引：索引页。图书最后几页，提供的根据关键词，定位到具体页码文档

   ​	单词 ==> 文档ID的关联

   ![1594659901650](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1594659901650.png)

   ### 单词词典 Term Dictionary

   ​	记录所有文档的单词，**单词**到**倒排列表**的关联关系。

   ​	单词词典比较大，用B+树或哈希拉链法实现，满足高性能查询

   ### 倒排列表 Posting List

   ​	记录单词对应的文档集合，倒排索引项组成

   ​	倒排索引项Posting：文档ID、词频TF(次数、相关性评分)、位置Position（单词在文档中分词位置）、偏移Offset

   elasticsearch的json文档中的每个字段，都有自己的倒排索引

   可以指定对某些字段不做索引，节省存储空间

5. 通过分析器进行分词

   Analysis 分词   Analyzer分词器

   写入是分词器处理成词条，查询时同样用分词器分析

   Analyzer：

   ​	Character Filters 原始文本处理，剥离html标签 

   ​	Tokenizer 规则切分 

   ​	Token Filter 切分后单词的加工 (小写，删除stopwords、增加同义词)

   _analyzer API

   ```json
   // 查看分词器工作过程
   GET _analyze
   {
     "analyzer": "standard",
     "text":"I read book, a useful book"
   }
   // 查看索引的某字段上如何分词
   GET books/_analyze
   {
     "field":"title",
     "text":"elastic is good for search"
   }
   // 自定义分词进行测试
   POST _analyze
   {
     "tokenizer":"standard",
     "filter":["lowercase"],
     "text":"Master elastic"
   }
   ```

   默认 Standard Analyzer. 按词切分、小写处理 

   Simple Analyzer：按照非字母字符切分，非字母全部取出，转小写处理

   Whitespace Analyzer： 按空格切分

   Stop Analyzer： 去除the a is 修饰词

   Keyword Analyzer： 不分词，直接将输入当一个term输出 <font color=red>不分词时使用</font>

   Pattern Analyzer：使用正则表达式分词，默认用 \W+, 即非字母的符号分隔。转小写处理

   Language Analyzer：指定不同语言分词，如running--》run   dogs-->dog, 去除 in a the

   ICU Analyzer：插件plugin，中文分词，提供Unicode支持，支持亚洲语言

   IK：中文分词器，支持自定义词库，支持热更新

   THULAC：中文分词器，清华大学

6. #### Search API 概览

   **URI Search**：在url中使用查询参数

   | /_search               | 集群中所有的索引    |
   | ---------------------- | ------------------- |
   | /index1/_search        | index1查询          |
   | /index1,index2/_search | index1和index2      |
   | /index*/_search        | 所有index开头的索引 |

   ```http
   curl -XGET
   "http://elasticsearch:9200/kibana_index/_search?q=first_name:Yang"
   ```

   **Request Body Search**：使用elasticsearch提供的基于JSON格式的更完备的DSL(Query Domain Specific Language)

   ```http
   curl -XGET
   "http://elasticsearch:9200/kibana_index/_search" -H
   {
   	"query":{
   		"match_all":{}
   	}
   }
   ```

   衡量相关性 information retrieval

   ​	Precision 查准率——尽可能返回较少的无关文档

   ​	Recall 查全率——尽量返回较多的相关文档

   ​	Ranking —— 是否能够按照相关度进行排序

7. ### URI Search 详解

   ```json
   // 查询title：2012，按year字段倒序，所有记录，取10条，超时时间1s
   GET /movies/_search?q=2012&df=title&sort=year:desc&from=0&size=10&timeout=1s
   ```

   ```json
   // 带profile查询，查看查询如何执行 查询response是200的结果，TermQuery，response：200
   GET /kibana_sample_data_logs/_search?q=200&df=response
   {
     "profile": "true"
   }
   // 同上效果，指定字段查询
   GET /kibana_sample_data_logs/_search?q=response:200
   {
     "profile": "true"
   }
   ```

   ```json
   // 泛查询，所有字段，效率不会很高
   GET /kibana_sample_data_logs/_search?q=200
   {
     "profile": "true"
   }
   ```

   指定字段 vs 泛查询： q=title: 2012   vs   q=2012

   Term vs Phrase: Beautiful Mind (Beautiful OR Mind)   vs  Beautiful Mind ( Beautiful AND Mind)

   ​	phrase查询，要求前后顺序保持一致

   分组与引号： title: (Beautiful AND Mind)     title: "Beautiful Mind"

   ```json
   // phrase 查询，2条精确结果
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:"Recip Graham"
   {
     "profile": "true"
   }
   // 泛查询，BooleanQuery，110条结果，Graham未指定，泛查询Graham
   // customer_full_name:recip (products.manufacturer:graham | MatchNoDocsQuery("failed [products.base_unit_price] query, caused by number_format_exception:[For input string: "Graham"]") | MatchNoDocsQuery("failed [products.discount_amount] query, caused by...
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:Recip Graham
   {
     "profile": "true"
   }
   // 分组，BooleanQuery，结果中包含Recip或者Graham。
   //  "description" : "customer_full_name:recip customer_full_name:graham",
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:(Recip Graham)
   {
     "profile": "true"
   }
   ```

   bool操作

   ​	默认两个词在一起是OR关系，支持AND、OR、NOT、或者 && || ！必须大写

   分组

   ​	+表示must -表示mustnot

   ```json
   // "description" : "+customer_full_name:recip +customer_full_name:graham",
   // q query ; df default默认字段;
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:(Recip AND Graham)
   {
     "profile": "true"
   }
   // %2B表示+
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:(Recip %2B Graham)
   {
     "profile": "true"
   }
   //  "description" : "customer_full_name:recip -customer_full_name:graham",
   GET /kibana_sample_data_ecommerce/_search?q=customer_full_name:(Recip NOT Graham)
   {
     "profile": "true"
   }
   ```

   范围查询

   ```json
   GET /index/_search?q=year:>=1980
   {
   	"profile":"true"
   }
   ```

   通配符查询

   ```json
   // iterm查询，只要其中有一个包含就成立
   GET /index/_search?q=title:b*
   {
   	"profile":"true"
   }
   // 命中 title：”Fathar of the Bride part II“
   ```

   正则表达式

   模糊匹配 & 近似匹配

   ```json
   // iterm查询，做一个字母差别的模糊查询
   GET /index/_search?q=title:beautifl~1
   // phrase查询，Loard Rings中间可以有两个任意单词，title："Loard of the Rings,the"
   GET /index/_search?q=title:"Loard Rings"~2
   ```

8. Request Body 与 Query DSL 简介

   将查询语句通过http request body 发送给elasticsearch

   ```http
   POST /movies,index2/_search?ignore_unavailable=true
   {
   	"profile":true，
   	”query“:{
   		"match_all":{}
   	}
   }
   ```

   分页

   ```http
   POST /index/_search
   {
   	"from":10,
   	"size":20,
   	"query":{
   		"match_all":{}
   	}
   }
   ```

   排序

   ```json
   // 在数字型或日期型字段上排序，
   GET /index/_search
   {
   	"sort":[{"timestamp":"desc"}],
   	"from":10,
   	"size":5,
   	"query":{
   		"match_all":{}
   	}
   }
   ```

   Source filtering

   ```http
   // _source支持使用通配符 * 
   GET /index/_search
   {
   	"_source":["iterm1","iterm2","iterm3.keyword"],
   	"from":10,
   	"size":5,
   	"query":{
   		"match_all":{}
   	}
   }
   ```

   脚本字段

   ```http
   // 场景，如订单中有不同汇率，需要结合汇率，对订单价格进行排序，
   // 通过painless字段，算出一个结果。订单时间和hello做一个拼接
   // 
   GET /index/_search
   {
   	"script_fields":{
   		"new_field":{
   			"script":{
   				"lang":"painless",
   				"source":"doc['order_date'].value+'hello'"
   			}
   		}
   	},
   	"from":10,
   	"size":5,
   	"query":{
   		"match_all":{}
   	}
   }
   ```

   term search、phrase search

   ```http
   GET /index/_search
   {
   	"query":{
   		"match":{
   			"comment":"Last week"  // 默认是or，last 或者week
   		}
   	}
   }
   // 词语必须按顺序出现
   GET /index/_search
   {
   	"query":{
   		"match":{
   			"comment":"Last week",
   			"operator":"AND"
   		}
   	}
   }
   // match phrase, slop中间可以插入一个任意词
   GET /index/_search
   {
   	"query":{
   		"match_phrase":{
   			"comment":"last week",
   			"slop":1
   		}
   	}
   }
   ```

9. Query String & Simple Query String 查询

   类似URI query

   ```http
   POST /index/_search
   {
   	"query":{
   		"query_string":{
   			"default_field":"name",
   			"query":"Yang AND Qiang"
   		}
   	}
   }
   POST /index/_search
   {
   	"query":{
   		"query_string":{
   			"fields":["name","about"],
   			"query":"(Yang AND Qiang) OR (Java AND Elasticsearch)"
   		}
   	}
   }
   ```

   Simple Query String 

   ​	类似 Query String ，但会忽略错误语法，同时只支持部分查询语法

   ​	不支持AND OR NOT ，会当做字符串处理

   ​	Term之间默认的关系是OR，可以指定operator

   ​	支持部分逻辑：+替代AND   | 替代OR     - 替代NOT

   ```http
   // 包含Yang，不包含Qiang
   POST /index/_search
   {
   	"query":{
   		"simple_query_string":{
   			"query":"Yang -Qiang",
   			"fields":["name"],
   			"default_operator":"AND"
   		}
   	}
   }
   ```

10. Dynamic Mapping 和常见字段类型

    Mapping 类似数据库中的schema定义

    	- 定义索引总的**字段名称**
    	- 定义字段的**数据类型**，字符串、数字、布尔。。。
    	- 字段，倒排索引的相关配置，（Analyzed or Not Analyzed，Analyzer）

    Mapping会把JSON文档映射成Lucene所需要的扁平格式

    一个Mapping属于一个索引的Type，(其实是一类格式字段的文档)

    	- 每个文档都属于一个Type
    	- 一个Type有一个Mapping定义
    	- 7. 0后，不需要在Mapping 定义中指定Type信息

    字段的数据类型

    - 简单类型
      - Text/ Keyword
      - Date
      - Integer / Floating
      - Boolean
      - IPv4 & IPv6
    - 复杂类型-对象和嵌套对象
      - 对象类型/ 嵌套类型
    - 特殊类型
      - geo_point & geo_shape / percolator 

    Dynamic Mapping 动态索引

    * 在写入文档时，如果索引不存在，会自动创建索引
    * elasticsearch根据文档信息，自动推算出字段的类型
    * 当类型推测或设置不对时，会导致一些功能无法正常运行，如Range 

    类型推测机制

    | JSON类型 | Elasticsearch类型                                            |
    | -------- | ------------------------------------------------------------ |
    | 字符串   | - 匹配日期格式，设置为Date<br />- 匹配数字设置为Float或long，该选项默认关闭<br />- 设置为Text，并且增加keyword子字段 |
    | 布尔值   | boolean                                                      |
    | 浮点数   | float                                                        |
    | 整数     | long                                                         |
    | 对象     | Object                                                       |
    | 数组     | 由第一个非空数值的类型决定                                   |
    | 空值     | 忽略                                                         |

    ```json
    // 查看字段mapping定义
    GET /mapping_tesst/_mapping
    ```

    能否更改Mapping的字段类型

    1. 新增加字段

       Dynamic =true时，新增字段写入，Mapping同时被更新

       Dynamic= false 时，新增字段 ，Mapping不会更新，意味着该字段数据无法被索引，但信息会出现在_source中

       Dynamic设置为Strict，新增字段，文档写入失败

    2. 已有字段，一旦已经有数据写入，就不再支持修改字段定义

       Lucene实现的倒排索引，一旦生成后，就不允许修改

       如果希望改变字段类型，必须Reindex API，重建索引

    原因：

    ​	如果修改了字段的数据类型，会导致已被索引的属性无法被索引。要去重新修改已创建的索引结构。不支持

    ​	但是如果增加新的字段，就不会有影响。

    Dynamic Mappings设置

    |               | “true” | "faluse" | "strict" |
    | ------------- | ------ | -------- | -------- |
    | 文档可索引    | √      | √        | ×        |
    | 字段可索引    | √      | ×        | ×        |
    | Mapping可更新 | √      | ×        | ×        |

    

    显式 Mapping 设置与常见参数介绍

    ``` json
    PUT /index/
    {
    	"mappings":{
    		//...
    	}
    }
    ```

    Mapping设置 通常做法：

    - 创建一个临时的index，写入一些样本数据
    - 通过访问Mapping API 获得系统对该临时文件的动态mapping是否合适
    - 修改不对的mapping，使用该配置创建自己的索引
    - 删除临时索引

    控制当前字段是否被索引

    - **index** - 决定当前字段是否被索引，默认为true，设置为false，表示不可被索引

    ```json
    // 将用户手机号设置成不可索引，1.保护隐私。2.节省磁盘开销。
    // index的设置需要在数据写入前设置，否则会报index字段值不一致冲突
    PUT /index/
    {
    	"mappings":{
    		"properties":{
    			"firstName":{
    				"type":"text"
    			},
    			"lastName":{
    				"type":"text"
    			},
    			"mobile":{
    				"type":"text",
    				"index":false
    			}
    		}
    	}
    }
    ```

    四种不同级别 **index_options 配置**，用来控制倒排索引记录的内容

    - docs - 记录doc id

    - freqs - 记录doc id和 term frequencies

    - positions - 记录doc id / term frequencies / term position

    - offsets - doc id /term frequencies / term position / character offsets

      text类型，默认记录positions，其他默认为docs

      记录内容越多，占用存储空间越大

    Null 值实现搜索，**设置 null_value**, 只有keyword类型支持设定为Null_value

    ```
    GET /index/_search?q=mobile:NULL
    PUT index
    {
    	"mappings":{
    		"properties":{
    			"firstName":{
    				"type":"text"
    			},
    			"mobile":{
    				"type":"keyword",
    				"null_value":"NULL"
    			}
    		}
    	}
    }
    ```

    copy_to设置，满足一些特定的搜索需求

    	1. _all在7以后被copy_to替代
     	2. copy_to将字段的数值拷贝到目标字段，实现类似_all的作用
     	3. copy_to的目标字段，不在_source中出现

    ```json
    PUT index
    {
    	"mappings":{
    		"properties":{
    			"firstName":{
    				"type":"text",
    				"copy_to":"fullName",
    			},
    			"lastName":{
    				"type":"text",
    				"copy_to":"fullName"
    			}
    		}
    	}
    }
    
    GET /index/_search?q=fullName:(Yang Qiang)
    ```

11. 多字段特性及 Mapping 中配置自定义 Analyzer

    - 增加一个keyword字段，厂商名字，实现精确匹配
    - 使用不同的analyzer，不同语言、拼音字段的搜索、还支持为搜索和索引指定不同的analyzer

    ```json
    PUT /index/
    {
    	"mapping":{
    		"properties":{
    			"company":{
    				"type":"text",
    				"fields":{
    					"keyword":{
    						"type":"text",
    						"ignore_above":256
    					}
    				}
    			},
    			"comment":{
    				"type":"text",
    				"fields":{
    					"english_comment":{
    						"type":"text",
    						"analyzer":"english",
    						"search_anaylzer":"english"
    					}
    				}
    			}
    		}
    	}
    }
    ```

    exact value  vs   full text 精确值与全文本比较

    ​	exact value：不需要被分词，elasticsearch中的keyword。包含数字、日期、具体一个字符串

    ​	full text：elasticsearch中的text，非结构化的文本数据

    自定义分词器：通过自组合不同的组件实现，Character Filter、Tokenizer、Token Filter

    ​	Character Filters：在Tokenizer之前对文本进行处理，增加、删除、替换字符，可以配置多个Filters

    ​		自带：HTML strip(去除html标签)；Mapping（字符串替换）；Pattern replace（正则匹配替换）

    ​	Tokenizer：将文本按照一定规则，切分为词 (term or token)

    ​		内置：whitespace、standerd、uax_url_email、pattern、keyword、path hierarchy

    ​		可以用java开发插件，实现自己的Tokenizer

    ​	Token Filters: 将Tokenizer输出的单词term，进行增加、删除、修改

    ​		自带：Lowercase、stop、synonym (添加近义词)

    char_filter

    ```json
    // keyword，不做分词处理；html_strip,去除html标签
    POST _analyze
    {
      "tokenizer": "keyword",
      "char_filter": ["html_strip"],
      "text": "<b>hello world</b>"
    }
    // 使用标准分词，标点符号和空格会被分词；将-替换为_
    POST _analyze
    {
      "tokenizer": "standard",
      "char_filter": [{
        "type":"mapping",
        "mappings":["- => _"]
      }],
      "text":"123-456,I-test!test 6-6_0"
    }
    // 将表情符替换为实际内容
    POST _analyze
    {
      "tokenizer": "standard",
      "char_filter": [{
        "type":"mapping",
        "mappings":[":) => happy",":( => sad"]
      }],
      "text": ["I am felling :)", "Felling :( today"]
    }
    // 正则替换，"token" : "www.elastic.co",
    POST _analyze
    {
      "tokenizer": "standard",
      "char_filter": [{
        "type":"pattern_replace",
        "pattern":"http://(.*)",
        "replacement":"$1"
      }],
      "text": ["http://www.elastic.co"]
    }
    // 按路径切分term
    POST _analyze
    {
      "tokenizer": "path_hierarchy",
      "text": ["/user/a/ba/b/c/d"]
    }
    ```

    token_filter

    ```json
    // whitespace与stop。空格分词，对分完的iterm进行过滤，过滤in a on 辅助停词
    GET _analyze
    {
      "tokenizer": "whitespace",
      "filter": ["stop"],
      "text": ["The rain in Spain is a big Rain"]
    }
    // 加入lowercase后，The被当做stopword删除，将分词先做一个小写，然后用stopword去除掉
    // filter内部是顺序相关的。
    GET _analyze
    {
      "tokenizer": "whitespace",
      "filter": ["lowercase","stop"],
      "text": ["The girls in China is a Game!"]
    }
    ```

    创建索引时指定分词器

    ```json
    PUT my_index
    {
      "settings": {
        "analysis": {
          "analyzer": {
            "my_custom_analyzer":{
              "type":"custom",
              "char_filter":["emoticons"],
              "tokenizer":"punctuation",
              "filter":["lowercase","english_stop"]
            }
          },
          "tokenizer": {
            "punctuation":{
              "type":"pattern",
              "pattern":"[ .,!?]"
            }
          },
          "char_filter": {
            "emoticons":{
              "type":"mapping",
              "mappings":[
                ":) => _happy_",
                ":( => _sad_"
                ]
            }
          },
          "filter": {
            "english_stop":{
              "type":"stop",
              "stopwords":["_english_"]
            }
          }
        }
      }
    }
    
    POST /my_index/_analyze
    {
      "analyzer": "my_custom_analyzer",
      "text": ["I'm a :) person, and you?"]
    }
    ```

12. Index Template 和 Dynamic Template 索引模板与动态模板

    index Templates 帮助设定Mappings和Settings，并按照一定的规则，自动匹配到新创建的索引之上

    - 模板尽在一个索引被创建时，才会产生作用。修改模板，不影响已创建的索引
    - 可以设置多个索引模板，这些设置会被**merge**在一起
    - 可以指定**order**的数值，控制merging的过程

    ```json
    // 设置所有的分片在创建时，把主分片和副本分片都设置为1
    PUT _template/template_default
    {
      "index_patterns": ["*"],
      "order": 0,
      "version": 1,
      "settings": {
        "number_of_shards": 1,
        "number_of_replicas": 1
      }
    }
    // 模板：以test开头的索引，主分片1、副本分片2，关掉日期类型探测，打开数值类型探测(字符串数字)long型
    PUT _template/template_test
    {
      "index_patterns": ["test*"],
      "order": 0,
      "settings": {
        "number_of_shards": 1,
        "number_of_replicas": 2
      },
      "mappings": {
        "date_detection": false,
        "numeric_detection": true
      }
    }
    // 查看设置
    GET _template/temp*
    ```

    - 索引创建时，使用默认的settings和mappings
    - 先使用order数值低的index template模板设定
    - 再使用order高的，相同时，低的会被覆盖
    - 最后，使用创建索引时，如果用户指定的Settings和mappings，覆盖上面相同的。

    ```json
    // 日期被自动推算为date，数字依然是字符串
    PUT template_test/_doc/1
    {
      "mynum":"1",
      "mydate":"2019/01/01"
    }
    // 创建索引时需要先指定类型，
    PUT template_test
    {
      "mappings":{
        "properties":{
        "mynum":{
          "type":"long"
        	}
      	}
      }
    }
    ```

    Dynamic Template

    根据elasticsearch识别的数据类型，结合字段名称，动态设定字段类型，比如

    - 所有的字符串类型，都设定成Keyword，或关闭keyword字段
    - is开头的字段都设置成boolean
    - long_开头的都设置成long类型

    ```json
    PUT my_index
    {
      "mappings":{
        "dynamic_templates":[
          {
          "string_as_boolean":{
            "match_mapping_type":"string",
            "match":"is*",
            "mapping":{
              "type":"boolean"
            }
           }
          },{
          "string_as_keywords":{
            "match_mapping_type":"string",
            "mapping":{
              "type":"keyword"
            }
          }
        }]
      }
    }
    // dynamic_templates 在mappings中设置，起一个template名称
    // 匹配规则是一个数组
    // 为要匹配的字段full_name设置mapping
    PUT my_test_index
    {
      "mappings": {
        "dynamic_templates":[{ //中括号中每一个表示一个字段映射规则
          "full_name_rule":{
            "path_match":"name.*",  // 匹配规则，path是name.下的所有值
            "path_unmatch":"*.middle",
            "mapping":{
              "type": "text",  
              "copy_to":"full_name" // copy到full_name中,查询时就可以用full_name字段查询
            }
          }
        }]
      }
    }
    ```

13. Elasticsearch 聚合分析简介

    Aggregation 功能： es提供除搜索之外的统计分析功能

    实时性高，Hadoop （T+1）

    - Bucket Aggregation —— 一些列满足特定条件的文档的集合，分成一个个桶
    - Metric Aggregation —— 一些数学运算，可以对文档字段进行统计分析
    - Pipeline Aggregation —— 对其他的聚合结果，进行二次聚合
    - Matrix Aggregation —— 支持对多个字段的操作并提供一个结果矩阵

    Bucket：类似sql中的group by xx，根据条件把结果分成一个个组

    ​	提供多种类型的bucket，帮助划分文档；Term & Range (时间/ 年龄区间/ 地理位置)

    ```json
    // 查看航班目的地统计信息
    GET index/_search
    {
    	"size":0, // 结果中不输出hits
    	"aggs":{
    		"flight_dest":{ // 存储聚合结果的名称
    			"terms":{
    				"field":"DestCountry"  // 指定聚合group by的字段
    			}
    		}
    	}
    }
    ```

    Metric：类似sql中的count，执行一些统计方法，数学运算

    ​	支持在字段上计算，也支持在脚本painless script产生的结果上进行计算

    ​	min/ max/ sum/ avg/ cardinality

    ​	部分metric支持输出过个数值，stats / percentiles / percentile_ranks

    ```json
    // 查看航班目的地统计信息，增加均价，最高，最低价格
    GET index/_search
    {
    	"size":0,
    	"aggs":{
    		"flight_dest":{
    			"terms":{
    				"field":"DestCountry" // 自动带doc_count统计值
    			}
    		},
    		"aggs":{
    			"average_price":{ // 自定义输出结果桶
    				"avg":{
    					"field":"AvgTicketPrice"
    				}
    			}，
    			"max_price":{
    				"max":{
    					"field":"AvgTicketPrice"
    				}
    			},
    			"min_price":{
    				"min":{
    					"field":"AvgTicketPrice"
    				}
    			}
    		}
    	}
    }
    // 嵌套，先按目的地分桶，然后每桶再按天气划分
    GET index/_source
    {
        "size":0,
        "aggs":{
            "flight_dest":{
                "terms":{
                    "field":"DestCountry"
                }
            },
            "aggs":{
                "average_price":{
                    "avg":{
                        "field":"AvgTicketPrice"
                    }
                },
                "weather":{
                    "terms":{
                        "field":"DestWeather"
                    }
                }
            }
        }
    }
    ```

14. 第一部分总结

## 第二部分：深入了解 Elasticsearch

### 第 4 章：深入搜索

1. 基于词项和基于全文的搜索—— **如何精确匹配**

   Term查询：term是表达语意的最小单位，搜索和利用统计语言模型进行自然语言处理都需要term

   Term级查询：Term Query、Range Query、Exists Query、Prefix Query、Wildcard Query

   ES中，Term查询，对输入不做分词，作为一个整体，在倒排索引中查找准确的词项，使用相关度计算为每个包含该词项的文档进行相关度算分。

   通过Constant Score可以将查询转换成一个Filtering，避免算分，并利用缓存，提高性能。

   ```json
   POST /product/_bulk
   {"index":{"_id":1}}
   {"productID":"XHDK-A-124-#fJ3","desc":"iPhone"}
   
   POST /index/_search
   {
   	"query":{
   		"term":{
   			"desc":{
   				// "value":"iPhone" // term不分词查询，查不到，因为es在存的时候会存为小写
   				"value":"iphone" // 有返回结果
   			}
   		}
   	}
   }
   
   POST /index/_search
   {
     "query":{
   		"term":{
   			"productID":{   // 完整term匹配需要用keyword "productID.keyword":{
   				// "value":"XHDK-A-124-#fJ3" // term不分词查询，查不到，因为es在存的时候会存为小写
   				"value":"xhdk"  // 有返回结果
   			}
   		}
   	}
   }
   ```

   将Query转成Filter，忽略TF-IDF计算，避免相关性算分的开销

   ```json
   POST /index/_search
   {
   	"explain":true,
   	"query":{
     	"constant_score":{  // 约束算分---过滤term
     		"filter":{
     			"term":{
     				"productID.keyword":"XHDK-A-124-#fJ3"
     			}
     		}
     	}
     }
   }
   ```

   基于全文本查询

   - Match Query / Match Phrase Query / Query String Query

     索引和搜索时都进行分词，要查询的串先用分词器生成可供查询的词项列表。然后每个词项如歌进行底层查询，最后将结果合并，为每个文档生成算分。

     ![1595438952706](E:\GIT\XmindNote\数据库/1595438952706.png) 

   通过Mapping字段控制字段的分词，设置为keyword后，es不再对该字段分词

   

   

2. 结构化搜索

3. 搜索的相关性算分

4. Query & Filtering 与多字符串多字段查询

5. 单字符串多字段查询：Dis Max Query

6. 单字符串多字段查询：Multi Match

7. 多语言及中文分词与检索

8. Space Jam，一次全文搜索的实例

9. 使用 Search Template 和 Index Alias 查询

10. 综合排序：Function Score Query 优化算分

11. Term & Phrase Suggester

12. 自动补全与基于上下文的提示

13. 配置跨集群搜索

### 第 5 章：分布式特性及分布式搜索的机制

1. 集群分布式模型及选主与脑裂问题
2. 分片与集群的故障转移
3. 文档分布式存储
4. 分片及其生命周期
5. 剖析分布式查询及相关性算分
6. 排序及 Doc Values & Fielddata
7. 分页与遍历：From, Size, Search After & Scroll API
8. 处理并发读写操作

### 第 6 章：深入聚合分析

1. Bucket & Metric 聚合分析及嵌套聚合
2. Pipeline 聚合分析
3. 作用范围与排序
4. 聚合分析的原理及精准度问题

### 第 7 章：数据建模

1. 对象及 Nested 对象
2. 文档的父子关系
3. Update By Query & Reindex API
4. Ingest Pipeline & Painless Script
5. Elasticsearch 数据建模实例
6. Elasticsearch 数据建模最佳实践
7. 第二部分总结回顾

## 第三部分：管理 Elasticsearch 集群

### 第 8 章：保护你的数据

1. 集群身份认证与用户鉴权
2. 集群内部安全通信
3. 集群与外部间的安全通信

### 第 9 章：水平扩展 Elasticsearch 集群

1. 常见的集群部署方式
2. Hot & Warm 架构与 Shard Filtering
3. 如何对集群进行容量规划
4. 分片设计及管理
5. 在私有云上管理 Elasticsearch 集群的一些方法
6. 在公有云上管理与部署 Elasticsearch 集群

### 第 10 章：生产环境中的集群运维

1. 生产环境常用配置与上线清单
2. 监控 Elasticsearch 集群
3. 诊断集群的潜在问题
4. 解决集群 Yellow 与 Red 的问题
5. 提升集群写性能
6. 提升进群读性能
7. 集群压力测试
8. 段合并优化及注意事项
9. 缓存及使用 Breaker 限制内存使用
10. 一些运维的相关建议

### 第 11 章：索引生命周期管理

1. 使用 Shrink 与 Rollover API 有效管理时间序列索引
2. 索引全生命周期管理及工具介绍

## 第四部分：利用 ELK 做大数据分析

### 第 12 章：用 Logstash 和 Beats 构建数据管道

1. Logstash 入门及架构介绍
2. Beats 介绍

### 第 13 章：用 Kibana 进行数据可视化分析

1. 使用 Index Pattern 配置数据
2. 使用 Kibana Discover 探索数据
3. 基本可视化组件介绍
4. 构建 Dashboard

## 第 14 章：探索 X-Pack 套件

1. 用 Monitoring 和 Alerting 监控 Elasticsearch 集群
2. 用 APM 进行程序性能监控
3. 用机器学习实现时序数据的异常检测（上）
4. 用机器学习实现时序数据的异常检测(下）
5. 用 ELK 进行日志管理
6. 用 Canvas 做数据演示

## 第五部分：应用实战工作坊

### 实战 1：电影搜索服务

1. 项目需求分析及架构设计
2. 将音乐数据导入 Elasticsearch
3. 搭建你的电影搜索服务
4. 基于 Java 和 Elasticsearch 构建应用

### 实战 2：Stackoverflow 用户调查问卷分析

1. 需求分析及架构设计
2. 数据 Extract & Enrichment
3. 构建 Insights Dashboard

### 备战：Elastic 认证

1. Elastic 认证介绍
2. 考点梳理
3. 集群的数据备份