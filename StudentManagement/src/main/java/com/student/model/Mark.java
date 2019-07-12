package com.student.model;

public class Mark {
	private int lang1;
	private int lang2;
	private int math;
	private int science;
	private int social;

	public int getLang1() {
		return lang1;
	}

	public void setLang1(int language1) {
		this.lang1 = language1;
	}

	public int getLang2() {
		return lang2;
	}

	public void setLang2(int language2) {
		this.lang2 = language2;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	@Override
	public String toString() {
		return "Mark [lang1=" + lang1 + ", lang2=" + lang2 + ", math=" + math + ", science=" + science + ", social="
				+ social + "]";
	}

}
