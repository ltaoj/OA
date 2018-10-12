package com.yunlg.oa.persistence.impl;

import com.yunlg.oa.domain.model.Staff;
import com.yunlg.oa.persistence.AbstractDAO;
import com.yunlg.oa.persistence.StaffDAO;
import com.yunlg.oa.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

@Repository
public class StaffDAOImpl extends AbstractDAO implements StaffDAO {

    @Override
    public Staff getStaff(String userId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransaction(session);
        try {
            String hql = "from Staff where userId='" + userId + "'";
            Staff staff = (Staff) session.createQuery(hql).uniqueResult();
            session.flush();
            transaction.commit();
            return staff;
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
