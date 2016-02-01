package com.example.bestpractices.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 这个实体用于展示Parcelable传递的方式
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
		dest.writeString(name);// 写出name
		dest.writeInt(age);// 写出age
	}

	public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

		// 顺序要与上面写入的一致
		@Override
		public Person createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.name = source.readString(); // 读取name
			person.age = source.readInt(); // 读取age
			return person;
		}

		@Override
		public Person[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Person[size];
		}
	};
}
