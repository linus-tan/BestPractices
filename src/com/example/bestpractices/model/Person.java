package com.example.bestpractices.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ���ʵ������չʾParcelable���ݵķ�ʽ
 * 
 * @author linus
 */
public class Person implements Parcelable {
	private String name;
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);// д��name
		dest.writeInt(age);// д��age
	}

	public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

		// ˳��Ҫ������д���һ��
		@Override
		public Person createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.name = source.readString(); // ��ȡname
			person.age = source.readInt(); // ��ȡage
			return person;
		}

		@Override
		public Person[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Person[size];
		}
	};
}
