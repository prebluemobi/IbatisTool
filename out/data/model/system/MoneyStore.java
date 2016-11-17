package com.bluemobi.www.data.model.discover;

import java.io.Serializable;
import com.bluemobi.www.data.model.BaseEntity;

/**
 * money_store实体表()
 * @author lip
 * @date 2016-09-14 07:16:19
 * @project 上海科匠信息科技有限公司 2015
 */
 @SuppressWarnings("serial")
public class MoneyStore extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String userid; // 用户id
	private java.math.BigDecimal money; // 金额
	private java.lang.String reverse1; // 
	private java.lang.String reverse2; // 
	private java.lang.String revsere3; // 
	private java.lang.String passwd; // 密码
	/**
     * 获取属性
     *
     * @return id
     */
	public java.lang.String getId() {
		return id;
	}
	
	/**
	 * 设置属性
	 *
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	/**
     * 获取用户id属性
     *
     * @return userid
     */
	public java.lang.String getUserid() {
		return userid;
	}
	
	/**
	 * 设置用户id属性
	 *
	 * @param userid
	 */
	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}
	
	/**
     * 获取金额属性
     *
     * @return money
     */
	public java.math.BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置金额属性
	 *
	 * @param money
	 */
	public void setMoney(java.math.BigDecimal money) {
		this.money = money;
	}
	
	/**
     * 获取属性
     *
     * @return reverse1
     */
	public java.lang.String getReverse1() {
		return reverse1;
	}
	
	/**
	 * 设置属性
	 *
	 * @param reverse1
	 */
	public void setReverse1(java.lang.String reverse1) {
		this.reverse1 = reverse1;
	}
	
	/**
     * 获取属性
     *
     * @return reverse2
     */
	public java.lang.String getReverse2() {
		return reverse2;
	}
	
	/**
	 * 设置属性
	 *
	 * @param reverse2
	 */
	public void setReverse2(java.lang.String reverse2) {
		this.reverse2 = reverse2;
	}
	
	/**
     * 获取属性
     *
     * @return revsere3
     */
	public java.lang.String getRevsere3() {
		return revsere3;
	}
	
	/**
	 * 设置属性
	 *
	 * @param revsere3
	 */
	public void setRevsere3(java.lang.String revsere3) {
		this.revsere3 = revsere3;
	}
	
	/**
     * 获取密码属性
     *
     * @return passwd
     */
	public java.lang.String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置密码属性
	 *
	 * @param passwd
	 */
	public void setPasswd(java.lang.String passwd) {
		this.passwd = passwd;
	}
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MoneyStore");
        sb.append("{id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", money=").append(money);
        sb.append(", reverse1=").append(reverse1);
        sb.append(", reverse2=").append(reverse2);
        sb.append(", revsere3=").append(revsere3);
        sb.append(", passwd=").append(passwd);
		sb.append('}');
        return sb.toString();
    }
    
}