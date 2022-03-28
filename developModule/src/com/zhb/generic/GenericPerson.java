package com.zhb.generic;

interface Info{		// ֻ�д˽ӿڵ�������Ǳ�ʾ�˵���Ϣ
}
class Contact implements Info{	// ��ʾ��ϵ��ʽ
	private String address ;	// ��ϵ��ַ
	private String telephone ;	// ��ϵ��ʽ
	private String zipcode ;	// ��������
	public Contact(String address,String telephone,String zipcode){
		this.address = address;
		this.telephone = telephone;
		this.zipcode = zipcode;
	}
	public void setAddress(String address){
		this.address = address ;
	}
	public void setTelephone(String telephone){
		this.telephone = telephone ;
	}
	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}
	public String getAddress(){
		return this.address ;
	}
	public String getTelephone(){
		return this.telephone ;
	}
	public String getZipcode(){
		return this.zipcode;
	}
	@Override
	public String toString() {
		return "Contact [address=" + address + ", telephone=" + telephone
				+ ", zipcode=" + zipcode + "]";
	}
}
class Introduction implements Info{
	private String name ;		// ����
	private String sex ;		// �Ա�
	private int age ;			// ����
	public Introduction(String name,String sex,int age){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public void setName(String name){
		this.name = name ;
	}
	public void setSex(String sex){
		this.sex = sex ;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public String getName(){
		return this.name ;
	}
	public String getSex(){
		return this.sex ;
	}
	public int getAge(){
		return this.age ;
	}
	@Override
	public String toString() {
		return "Introduction [name=" + name + ", sex=" + sex + ", age=" + age
				+ "]";
	}
}
class Person<T extends Info>{
	private T info ;
	public Person(T info){		// ͨ��������������Ϣ��������
		this.info = info;
	}
	public void setInfo(T info){
		this.info = info ;
	}
	public T getInfo(){
		return info ;
	}
	@Override
	public String toString() {
		return "Person [info=" + info + "]";
	}
	
}
public class GenericPerson{
	public static void main(String args[]){
		Person<Contact> per = null ;		// ����Person����
		per = new Person<Contact>(new Contact("������","01088888888","102206")) ;
		System.out.println(per);
		
		Person<Introduction> per2 = null ;		// ����Person����
		per2 = new Person<Introduction>(new Introduction("����","��",24));
		System.out.println(per2) ;
	}
}
