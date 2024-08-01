package noteapp.dto;

import java.util.Date;

public class UserDTOBuilder {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private Date createdAt;
	
	private UserDTOBuilder (UserBuilder userBuilder) {
		this.userId = userBuilder.userId;
		this.userName = userBuilder.userName;
		this.userPassword = userBuilder.userPassword;
		this.userEmail = userBuilder.userEmail;
		this.createdAt = userBuilder.createdAt;
	}
	
	public static class	UserBuilder {
		private Integer userId;
		private String userName;
		private String userPassword;
		private String userEmail;
		private Date createdAt;
		
		public UserBuilder setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}
		
		public UserBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}
		
		public UserBuilder setUserPassword(String userPassword) {
			this.userPassword = userPassword;
			return this;
		}
		
		public UserBuilder setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		
		public UserDTOBuilder build() {
            return new UserDTOBuilder(this);
        }
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
