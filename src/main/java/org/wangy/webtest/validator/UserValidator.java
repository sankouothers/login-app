package org.wangy.webtest.validator;

import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.wangy.webtest.command.UserCommand;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class UserValidator implements Validator {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   clazz  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean supports(Class clazz) {
    // TODO Auto-generated method stub
    return UserCommand.class.equals(clazz);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  obj     DOCUMENT ME!
   * @param  errors  DOCUMENT ME!
   */
  @Override public void validate(Object obj, Errors errors) {
    // TODO Auto-generated method stub
    UserCommand user = (UserCommand) obj;

    if (!StringUtils.hasText(user.getUsername())) {
      errors.rejectValue("username", null, "Username is empty.");
    } else if (user.getUsername().length() < 5) {
      errors.rejectValue("username", null, "Username must be greater than 5 characters.");
    } else if (user.getUsername().length() > 30) {
      errors.rejectValue("username", null, "Username cannot be less than 30 characters.");
    }

    if (!StringUtils.hasText(user.getPassword())) {
      errors.rejectValue("password", null, "Password is empty.");
    } else if (user.getPassword().length() < 3) {
      errors.rejectValue("password", null, "Password must be greater than 3 characters.");
    } else if (user.getPassword().length() > 10) {
      errors.rejectValue("password", null, "Password cannot be less than 10 characters.");
    }

    if (StringUtils.hasText(user.getBirthDateString())) {
      try {
        sdf.parse(user.getBirthDateString());
      } catch (Exception e) {
        e.printStackTrace();
        errors.rejectValue("birthDateString", null, "Invalid date format.");
      }
    }
  } // end method validate

} // end class UserValidator
