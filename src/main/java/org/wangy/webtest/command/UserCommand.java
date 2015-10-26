package org.wangy.webtest.command;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.util.StringUtils;

import org.wangy.webtest.model.Role;
import org.wangy.webtest.model.User;


/**
 * Created by Yang Wang on 8/27/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class UserCommand {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Integer age;
  private String  birthDateString;
  private String  email;
  private String  gender      = "male";
  private Integer id;
  private String  password;
  private String  phoneNumber;
// private MultipartFile photo;
  private String  username;
  private String  roleName;
  private Integer  roleId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserCommand object.
   */
  public UserCommand() { }

  /**
   * Creates a new UserCommand object.
   *
   * @param  user  DOCUMENT ME!
   */
  public UserCommand(User user) {
    this.id          = user.getId();
    this.username    = user.getUsername();
    this.password    = user.getPassword();
    this.gender      = user.getGender();
    this.age         = user.getId();
    this.email       = user.getEmail();
    this.phoneNumber = user.getPhoneNumber();

    if (user.getBirthDate() != null) {
      this.birthDateString = sdf.format(user.getBirthDate());
    }
    if(user.getRole()!=null){
      this.roleId = user.getRole().getId();
      this.roleName = user.getRole().getName();
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAge() {
    return age;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBirthDateString() {
    return birthDateString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGender() {
    return gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPassword() {
    return password;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
//~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUsername() {
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  age  DOCUMENT ME!
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  birthDateString  DOCUMENT ME!
   */
  public void setBirthDateString(String birthDateString) {
    this.birthDateString = birthDateString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  email  DOCUMENT ME!
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  gender  DOCUMENT ME!
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Integer id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  password  DOCUMENT ME!
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNumber  DOCUMENT ME!
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  username  DOCUMENT ME!
   */
  public void setUsername(String username) {
    this.username = username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  IOException  DOCUMENT ME!
   */
  public User toUser() throws IOException {
    User user = new User();
    user.setId(this.getId());
    user.setUsername(this.getUsername());
    user.setPassword(this.getPassword());
    user.setAge(this.getAge());
    user.setEmail(this.getEmail());
    user.setGender(this.getGender());
    user.setPhoneNumber(this.getPhoneNumber());

    if (StringUtils.hasText(this.getBirthDateString())) {
      try {
        Date date = sdf.parse(this.getBirthDateString());
        user.setBirthDate(date);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    if(this.getRoleId()!=null){
      Role role = new Role();
      role.setId(this.getRoleId());
      user.setRole(role);
    }

    return user;
  } // end method toUser
} // end class UserCommand
