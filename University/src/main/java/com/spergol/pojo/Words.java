package com.spergol.pojo;

public class Words {
	private int id;
	private String words;
	private int hot;
	private int related;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getRelated() {
		return related;
	}
	public void setRelated(int related) {
		this.related = related;
	}
	@Override
	public String toString() {
		return "Words [id=" + id + ", words=" + words + ", hot=" + hot + ", related=" + related + "]";
	}
	
}
