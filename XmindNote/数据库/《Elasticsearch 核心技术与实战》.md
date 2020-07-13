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

1. 基本概念（1）：索引，文档和 REST API

2. 基本概念（2）：节点，集群，分片及副本

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

3. 文档的基本 CRUD 与批量操作

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

   

   

6. Search API 概览

7. URI Search 详解

8. Request Body 与 Query DSL 简介

9. Query String & Simple Query String 查询

10. Dynamic Mapping 和常见字段类型

11. 显式 Mapping 设置与常见参数介绍

12. 多字段特性及 Mapping 中配置自定义 Analyzer

13. Index Template 和 Dynamic Template

14. Elasticsearch 聚合分析简介

15. 第一部分总结

## 第二部分：深入了解 Elasticsearch

### 第 4 章：深入搜索

1. 基于词项和基于全文的搜索
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