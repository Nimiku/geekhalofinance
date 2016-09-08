/*package cn.geekhalo.webtech.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shourong.invest.config.ShouRongConstants;
import com.shourong.invest.pojo.UserAccount;
import com.shourong.invest.util.TimeUtil;
*//**
 * 这个类为SpringSecurityContext上下文中的session信息
 * @author gim
 *
 *//*
public class SpringSessionInfo implements UserDetails,Serializable{

	private String id;

    private String username;

    private String password;

    private String nonDisable;

    private String nonExpired;

    private String noLocked;

    private String idNum;

    private String address;

    private String phone;

    private String accountNum;

    private String nickname;

    private String weixinNum;

    private String email;

    private String userType;

    private String isActive;

    private String bankCardNum;

    private String qqNum;

    private Date registerDate;

    private Date authenDate;

    private String realname;

    private Date birthday;

    private String payPwd;

    private String authenWaterNumber;

    private String userLevel;

    private String userExtraFlag;

    private String thirdPartIdOne;

    private String thirdPartIdTwo;

    private String inviteCode;

    private String photoPath;

    private String sex;

    private String lastLoginDate;

    private String companyAddress;

    private Date lockDate;

    private String backupOne;

    private String backupTwo;

    private String backupThree;

    private String bankName;

    private String emergencyPhone;

    private String emergencyName;

    private String receiveAddress;

    private String authenType;

    private String authenNum;

    private String emailAvailable;

    private Date otherDate;

    private String registerChannel;

    private String source;
    
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    
    private String totalEarn = "0.00";
    
    private Set<? extends GrantedAuthority> authorities;

    public SpringSessionInfo(UserAccount user,Set<? extends GrantedAuthority> authoritieSet){
    	this.id = user.getId();
		this.password = user.getPassword();
		this.username = user.getUsername();
	    this.accountNonExpired = user.getNonExpired().equals(ShouRongConstants.YES)?true:false;
		this.accountNonLocked = user.getNoLocked().equals(ShouRongConstants.YES)?true:false;
		this.credentialsNonExpired = user.getIsActive().equals(ShouRongConstants.YES)?true:false;
		this.enabled = user.getNonDisable().equals(ShouRongConstants.YES)?true:false;
		this.authorities = authoritieSet;
		this.idNum = user.getIdNum();
		this.address = user.getAddress();
		this.phone = user.getPhone();
		this.accountNum = user.getAccountNum();
		this.nickname = user.getNickname();
		this.weixinNum = user.getWeixinNum();
		this.email = user.getEmail();
		this.userType = user.getUserType();
		this.isActive = user.getIsActive();
		this.bankCardNum = user.getBankCardNum();
		this.qqNum = user.getQqNum();
		this.registerDate = user.getRegisterDate();
		this.authenDate = user.getAuthenDate();
		this.realname = user.getRealname();
		this.birthday = user.getBirthday();
		//敏感信息不放入session 
		//this.payPwd = user.getPayPwd();
		this.authenWaterNumber = user.getAuthenWaterNumber();
		this.userLevel = user.getUserLevel();
		this.userExtraFlag = user.getUserExtraFlag();
		this.thirdPartIdOne = user.getThirdPartIdOne();
		this.thirdPartIdTwo = user.getThirdPartIdTwo();
		this.inviteCode = user.getInviteCode();
		this.photoPath = user.getPhotoPath();
		this.sex = user.getSex();
		if(user.getLastLoginDate() != null){
			this.lastLoginDate = TimeUtil.getFormartDateTime12(user.getLastLoginDate());
		}else{
			this.lastLoginDate = "";
		}
		this.companyAddress = user.getCompanyAddress();
		this.lockDate = user.getLockDate();
		this.backupOne = user.getBackupOne();
		this.backupTwo = user.getBackupTwo();
		this.backupThree = user.getBackupThree();
		this.bankName = user.getBankName();
		this.emergencyPhone = user.getEmergencyPhone();
		this.emergencyName = user.getEmergencyName();
		this.receiveAddress = user.getReceiveAddress();
		this.authenType = user.getAuthenType();
		this.authenNum = user.getAuthenNum();
		this.emailAvailable = user.getEmailAvailable();
		this.otherDate = user.getOtherDate();
	}
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNonDisable() {
		return nonDisable;
	}

	public void setNonDisable(String nonDisable) {
		this.nonDisable = nonDisable;
	}

	public String getNonExpired() {
		return nonExpired;
	}

	public void setNonExpired(String nonExpired) {
		this.nonExpired = nonExpired;
	}

	public String getNoLocked() {
		return noLocked;
	}

	public void setNoLocked(String noLocked) {
		this.noLocked = noLocked;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getWeixinNum() {
		return weixinNum;
	}

	public void setWeixinNum(String weixinNum) {
		this.weixinNum = weixinNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getBankCardNum() {
		return bankCardNum;
	}

	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getAuthenDate() {
		return authenDate;
	}

	public void setAuthenDate(Date authenDate) {
		this.authenDate = authenDate;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPayPwd() {
		return payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public String getAuthenWaterNumber() {
		return authenWaterNumber;
	}

	public void setAuthenWaterNumber(String authenWaterNumber) {
		this.authenWaterNumber = authenWaterNumber;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserExtraFlag() {
		return userExtraFlag;
	}

	public void setUserExtraFlag(String userExtraFlag) {
		this.userExtraFlag = userExtraFlag;
	}

	public String getThirdPartIdOne() {
		return thirdPartIdOne;
	}

	public void setThirdPartIdOne(String thirdPartIdOne) {
		this.thirdPartIdOne = thirdPartIdOne;
	}

	public String getThirdPartIdTwo() {
		return thirdPartIdTwo;
	}

	public void setThirdPartIdTwo(String thirdPartIdTwo) {
		this.thirdPartIdTwo = thirdPartIdTwo;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public String getBackupOne() {
		return backupOne;
	}

	public void setBackupOne(String backupOne) {
		this.backupOne = backupOne;
	}

	public String getBackupTwo() {
		return backupTwo;
	}

	public void setBackupTwo(String backupTwo) {
		this.backupTwo = backupTwo;
	}

	public String getBackupThree() {
		return backupThree;
	}

	public void setBackupThree(String backupThree) {
		this.backupThree = backupThree;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public String getAuthenType() {
		return authenType;
	}

	public void setAuthenType(String authenType) {
		this.authenType = authenType;
	}

	public String getAuthenNum() {
		return authenNum;
	}

	public void setAuthenNum(String authenNum) {
		this.authenNum = authenNum;
	}

	public String getEmailAvailable() {
		return emailAvailable;
	}

	public void setEmailAvailable(String emailAvailable) {
		this.emailAvailable = emailAvailable;
	}

	public Date getOtherDate() {
		return otherDate;
	}

	public void setOtherDate(Date otherDate) {
		this.otherDate = otherDate;
	}

	public String getRegisterChannel() {
		return registerChannel;
	}

	public void setRegisterChannel(String registerChannel) {
		this.registerChannel = registerChannel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result
				+ ((accountNum == null) ? 0 : accountNum.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((authenDate == null) ? 0 : authenDate.hashCode());
		result = prime * result
				+ ((authenNum == null) ? 0 : authenNum.hashCode());
		result = prime * result
				+ ((authenType == null) ? 0 : authenType.hashCode());
		result = prime
				* result
				+ ((authenWaterNumber == null) ? 0 : authenWaterNumber
						.hashCode());
		result = prime * result
				+ ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result
				+ ((backupOne == null) ? 0 : backupOne.hashCode());
		result = prime * result
				+ ((backupThree == null) ? 0 : backupThree.hashCode());
		result = prime * result
				+ ((backupTwo == null) ? 0 : backupTwo.hashCode());
		result = prime * result
				+ ((bankCardNum == null) ? 0 : bankCardNum.hashCode());
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((companyAddress == null) ? 0 : companyAddress.hashCode());
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((emailAvailable == null) ? 0 : emailAvailable.hashCode());
		result = prime * result
				+ ((emergencyName == null) ? 0 : emergencyName.hashCode());
		result = prime * result
				+ ((emergencyPhone == null) ? 0 : emergencyPhone.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idNum == null) ? 0 : idNum.hashCode());
		result = prime * result
				+ ((inviteCode == null) ? 0 : inviteCode.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((lastLoginDate == null) ? 0 : lastLoginDate.hashCode());
		result = prime * result
				+ ((lockDate == null) ? 0 : lockDate.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result
				+ ((noLocked == null) ? 0 : noLocked.hashCode());
		result = prime * result
				+ ((nonDisable == null) ? 0 : nonDisable.hashCode());
		result = prime * result
				+ ((nonExpired == null) ? 0 : nonExpired.hashCode());
		result = prime * result
				+ ((otherDate == null) ? 0 : otherDate.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((payPwd == null) ? 0 : payPwd.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((qqNum == null) ? 0 : qqNum.hashCode());
		result = prime * result
				+ ((realname == null) ? 0 : realname.hashCode());
		result = prime * result
				+ ((receiveAddress == null) ? 0 : receiveAddress.hashCode());
		result = prime * result
				+ ((registerChannel == null) ? 0 : registerChannel.hashCode());
		result = prime * result
				+ ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((thirdPartIdOne == null) ? 0 : thirdPartIdOne.hashCode());
		result = prime * result
				+ ((thirdPartIdTwo == null) ? 0 : thirdPartIdTwo.hashCode());
		result = prime * result
				+ ((userExtraFlag == null) ? 0 : userExtraFlag.hashCode());
		result = prime * result
				+ ((userLevel == null) ? 0 : userLevel.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result
				+ ((weixinNum == null) ? 0 : weixinNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpringSessionInfo other = (SpringSessionInfo) obj;
		if (accountNonExpired != other.accountNonExpired)
			return false;
		if (accountNonLocked != other.accountNonLocked)
			return false;
		if (accountNum == null) {
			if (other.accountNum != null)
				return false;
		} else if (!accountNum.equals(other.accountNum))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (authenDate == null) {
			if (other.authenDate != null)
				return false;
		} else if (!authenDate.equals(other.authenDate))
			return false;
		if (authenNum == null) {
			if (other.authenNum != null)
				return false;
		} else if (!authenNum.equals(other.authenNum))
			return false;
		if (authenType == null) {
			if (other.authenType != null)
				return false;
		} else if (!authenType.equals(other.authenType))
			return false;
		if (authenWaterNumber == null) {
			if (other.authenWaterNumber != null)
				return false;
		} else if (!authenWaterNumber.equals(other.authenWaterNumber))
			return false;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (backupOne == null) {
			if (other.backupOne != null)
				return false;
		} else if (!backupOne.equals(other.backupOne))
			return false;
		if (backupThree == null) {
			if (other.backupThree != null)
				return false;
		} else if (!backupThree.equals(other.backupThree))
			return false;
		if (backupTwo == null) {
			if (other.backupTwo != null)
				return false;
		} else if (!backupTwo.equals(other.backupTwo))
			return false;
		if (bankCardNum == null) {
			if (other.bankCardNum != null)
				return false;
		} else if (!bankCardNum.equals(other.bankCardNum))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (companyAddress == null) {
			if (other.companyAddress != null)
				return false;
		} else if (!companyAddress.equals(other.companyAddress))
			return false;
		if (credentialsNonExpired != other.credentialsNonExpired)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailAvailable == null) {
			if (other.emailAvailable != null)
				return false;
		} else if (!emailAvailable.equals(other.emailAvailable))
			return false;
		if (emergencyName == null) {
			if (other.emergencyName != null)
				return false;
		} else if (!emergencyName.equals(other.emergencyName))
			return false;
		if (emergencyPhone == null) {
			if (other.emergencyPhone != null)
				return false;
		} else if (!emergencyPhone.equals(other.emergencyPhone))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idNum == null) {
			if (other.idNum != null)
				return false;
		} else if (!idNum.equals(other.idNum))
			return false;
		if (inviteCode == null) {
			if (other.inviteCode != null)
				return false;
		} else if (!inviteCode.equals(other.inviteCode))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (lastLoginDate == null) {
			if (other.lastLoginDate != null)
				return false;
		} else if (!lastLoginDate.equals(other.lastLoginDate))
			return false;
		if (lockDate == null) {
			if (other.lockDate != null)
				return false;
		} else if (!lockDate.equals(other.lockDate))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (noLocked == null) {
			if (other.noLocked != null)
				return false;
		} else if (!noLocked.equals(other.noLocked))
			return false;
		if (nonDisable == null) {
			if (other.nonDisable != null)
				return false;
		} else if (!nonDisable.equals(other.nonDisable))
			return false;
		if (nonExpired == null) {
			if (other.nonExpired != null)
				return false;
		} else if (!nonExpired.equals(other.nonExpired))
			return false;
		if (otherDate == null) {
			if (other.otherDate != null)
				return false;
		} else if (!otherDate.equals(other.otherDate))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (payPwd == null) {
			if (other.payPwd != null)
				return false;
		} else if (!payPwd.equals(other.payPwd))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		if (qqNum == null) {
			if (other.qqNum != null)
				return false;
		} else if (!qqNum.equals(other.qqNum))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (receiveAddress == null) {
			if (other.receiveAddress != null)
				return false;
		} else if (!receiveAddress.equals(other.receiveAddress))
			return false;
		if (registerChannel == null) {
			if (other.registerChannel != null)
				return false;
		} else if (!registerChannel.equals(other.registerChannel))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (thirdPartIdOne == null) {
			if (other.thirdPartIdOne != null)
				return false;
		} else if (!thirdPartIdOne.equals(other.thirdPartIdOne))
			return false;
		if (thirdPartIdTwo == null) {
			if (other.thirdPartIdTwo != null)
				return false;
		} else if (!thirdPartIdTwo.equals(other.thirdPartIdTwo))
			return false;
		if (userExtraFlag == null) {
			if (other.userExtraFlag != null)
				return false;
		} else if (!userExtraFlag.equals(other.userExtraFlag))
			return false;
		if (userLevel == null) {
			if (other.userLevel != null)
				return false;
		} else if (!userLevel.equals(other.userLevel))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (weixinNum == null) {
			if (other.weixinNum != null)
				return false;
		} else if (!weixinNum.equals(other.weixinNum))
			return false;
		return true;
	}

	public String getTotalEarn() {
		return totalEarn;
	}

	public void setTotalEarn(String totalEarn) {
		this.totalEarn = totalEarn;
	}

}
*/