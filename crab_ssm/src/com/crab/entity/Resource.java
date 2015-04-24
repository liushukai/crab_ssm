package com.crab.entity;

import java.util.List;

public class Resource
{
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.id
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.name
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.parentId
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private Integer parentid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.resKey
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private String reskey;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.type
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private String type;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.resUrl
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private String resurl;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.level
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private Integer level;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_resource.description
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	private String description;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.id
	 *
	 * @return the value of t_resource.id
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.id
	 *
	 * @param id
	 *            the value for t_resource.id
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.name
	 *
	 * @return the value of t_resource.name
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.name
	 *
	 * @param name
	 *            the value for t_resource.name
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setName(String name)
	{
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.parentId
	 *
	 * @return the value of t_resource.parentId
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public Integer getParentid()
	{
		return parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.parentId
	 *
	 * @param parentid
	 *            the value for t_resource.parentId
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setParentid(Integer parentid)
	{
		this.parentid = parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.resKey
	 *
	 * @return the value of t_resource.resKey
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public String getReskey()
	{
		return reskey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.resKey
	 *
	 * @param reskey
	 *            the value for t_resource.resKey
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setReskey(String reskey)
	{
		this.reskey = reskey == null ? null : reskey.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.type
	 *
	 * @return the value of t_resource.type
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.type
	 *
	 * @param type
	 *            the value for t_resource.type
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setType(String type)
	{
		this.type = type == null ? null : type.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.resUrl
	 *
	 * @return the value of t_resource.resUrl
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public String getResurl()
	{
		return resurl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.resUrl
	 *
	 * @param resurl
	 *            the value for t_resource.resUrl
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setResurl(String resurl)
	{
		this.resurl = resurl == null ? null : resurl.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.level
	 *
	 * @return the value of t_resource.level
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public Integer getLevel()
	{
		return level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.level
	 *
	 * @param level
	 *            the value for t_resource.level
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setLevel(Integer level)
	{
		this.level = level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_resource.description
	 *
	 * @return the value of t_resource.description
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_resource.description
	 *
	 * @param description
	 *            the value for t_resource.description
	 *
	 * @mbggenerated Fri Apr 24 11:32:18 CST 2015
	 */
	public void setDescription(String description)
	{
		this.description = description == null ? null : description.trim();
	}
	
	private List<Role> roles;

	public List<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}
}