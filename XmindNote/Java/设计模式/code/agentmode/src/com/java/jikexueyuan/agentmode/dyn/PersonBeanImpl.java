package com.java.jikexueyuan.agentmode.dyn;

/**
 * 全都是public，不安全，因此需要做代理。
 * 自己代理：
 * 		1) 自己不能给自己打分。控制rating访问
 * 		2）可设置名字、性别、兴趣。
 * 	其他用户代理：
 * 		1）可以打分。 开放rating操作
 * 		2）设置名字、性别、兴趣做限制。
 */
//
//
public class PersonBeanImpl implements PersonBean{
	String name;
	String gender;
	String interests;
	int rating;
	int ratingcount=0;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override
	public String getInterests() {
		// TODO Auto-generated method stub
		return interests;
	}

	/**
	 * 如果没有打过分数，返回0；
	 * 如果打过分数，返回平均分
	 * @return
	 */
	@Override
	public int getHotOrNotRating() {
		// TODO Auto-generated method stub
		if(ratingcount==0) 		return 0;
		return (rating/ratingcount);
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		this.gender=gender;
	}

	@Override
	public void setInterests(String interests) {
		// TODO Auto-generated method stub
		this.interests=interests;
	}

	@Override
	public void setHotOrNotRating(int rating) {
		// TODO Auto-generated method stub
		this.rating=rating;
		ratingcount++;
	}

}
