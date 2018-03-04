package com.muyus.muyucloud;

import com.muyus.muyucloud.data.mongodb.dao.AccountDAO;
import com.muyus.muyucloud.data.mongodb.dao.AccountLocalDAO;
import com.muyus.muyucloud.data.mongodb.entity.Account;
import com.muyus.muyucloud.data.mongodb.entity.AccountLocal;
import com.muyus.muyucloud.data.mongodb.entity.AccountRole;
import com.muyus.muyucloud.data.oss.repository.ImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuyuCloudApplicationTests {
	@Autowired
    ImageRepository imageRepository;
	@Autowired
	AccountLocalDAO accountLocalDAO;
	@Autowired
    AccountDAO accountDAO;
	@Test
	public void contextLoads() {
		imageRepository.upload("tset.jpg", "hello".getBytes());
	}

	@Test
	public void register(){
        Account account = new Account();
        account.setId("A1");
        account.setPhoneNumber("13522861483");
        account.setAlias("木渔");
        account.setRegisterTime(new Date());
        account.setStatus(1);

        List<AccountRole> roles = new LinkedList<>();
        roles.add(AccountRole.ROLE_ADMIN);
        account.setRoles(roles);

        accountDAO.save(account);

		AccountLocal accountLocal = new AccountLocal();
		accountLocal.setAccountId(account.getId());
		accountLocal.setPhoneNumber("13522861483");
		accountLocal.setPassword("$2a$11$/.fq7hZ0l8v1AgwvMYCCVeB0BPWwZ7vS2Ka4.AbQK5uAlV6PSQXg2");
		accountLocal.setStatus(1);

		accountLocalDAO.save(accountLocal);
	}
}
