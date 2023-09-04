package edu.kh.jdbc.model.dto;

// DTO (Data Transfer Object) : 데이터 전달용 객체
public class Member {

	/* DTO의 필드는 DB 컬럼과 비슷하게 작성되는 경우가 많음! */
	/* -> 상황에 따라서 필드가 추가 또는 삭제될 수 있음! (개발자 재량)*/
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	
	// java, DB의 char 구분하기!
	private String memberTel;
	
	private String memberAddress;
	
	// Date -> String으로 변환해서 사용할 예정
	private String enrollDate;
	
	private String memberDelFl;
	
	// 기본 생성자
	public Member() {}
	
	// 매개변수 생성자 (alt + shift +s -> o)
	public Member(String memberEmail, String memberPw, String memberNickname, String memberTel, String memberAddress) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
	}
	
	
	
	public Member(String memberEmail, String memberPw) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
	}
	
	public Member(String memberPw) {
		super();
		this.memberPw = memberPw;
	}

	public Member(int memberNo, String memberEmail, String memberPw, String memberNickname, String memberTel,
			String memberAddress, String enrollDate, String memberDelFl) {
		super();
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
		this.enrollDate = enrollDate;
		this.memberDelFl = memberDelFl;
	}

	// getter/setter (alt + shitf + s -> r)
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberDelFl() {
		return memberDelFl;
	}

	public void setMemberDelFl(String memberDelFl) {
		this.memberDelFl = memberDelFl;
	}

	// Object.toString 오버라이딩 (alt + shift + s -> s)
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberNickname=" + memberNickname + ", memberTel=" + memberTel + ", memberAddress=" + memberAddress
				+ ", enrollDate=" + enrollDate + ", memberDelFl=" + memberDelFl + "]";
	}
}
