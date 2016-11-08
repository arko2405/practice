package com.sudoku.beans;

public abstract class SudokuBlock {

	protected Integer id;
	protected Integer value;
	protected Boolean isEmty;

	protected SudokuBlock(Boolean isEmty) {
		this.isEmty = isEmty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Boolean getIsEmty() {
		return isEmty;
	}

	public void setIsEmty(Boolean isEmty) {
		this.isEmty = isEmty;
	}

}
