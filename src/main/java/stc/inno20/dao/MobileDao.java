package stc.inno20.dao;


import stc.inno20.pojo.Mobile;

public interface MobileDao {
  boolean addMobile(Mobile mobile);

  Mobile getMobileById(Integer id);

  boolean updateMobileById(Mobile mobile);

  boolean deleteMobileById(Integer id);
}
