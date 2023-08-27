package cn.edu.neu.store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class User {

	private int u_id;
	private String username;
	private String password;

	private String aveter;
	private int gender;
	private String email;
	private String phone;
	private int u_rank;

	private  int age;

	private MultipartFile userPicFile;
	private MultipartFile file;
	private String filePath;

	private String userSearch;

	private Integer page=1,count=6;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAveter() {
		return aveter;
	}

	public void setAveter(String aveter) {
		this.aveter = aveter;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getU_rank() {
		return u_rank;
	}

	public void setU_rank(int u_rank) {
		this.u_rank = u_rank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserSearch() {
		return userSearch;
	}

	public void setUserSearch(String userSearch) {
		this.userSearch = userSearch;
	}

	@Override
	public String toString() {
		return "User{" +
				"u_id=" + u_id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", aveter='" + aveter + '\'' +
				", gender=" + gender +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", u_rank=" + u_rank +
				", age=" + age +
				", userPicFile=" + userPicFile +
				", file=" + file +
				", filePath='" + filePath + '\'' +
				", userSearch='" + userSearch + '\'' +
				", img='" + img + '\'' +
				'}';
	}

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MultipartFile getGoodsPicFile() {
		return userPicFile;
	}

	public void setGoodsPicFile(MultipartFile userPicFile) {
		this.userPicFile = userPicFile;
	}


}
