package edu.hanoi.service.springhnservice;

import edu.hanoi.service.springhnservice.controller.UserRestServiceController;
import edu.hanoi.service.springhnservice.model.Group;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners(listeners = {ServletTestExecutionListener.class,
DependencyInjectionTestExecutionListener.class})
class WebServiceApplicationTests {

//    @Autowired
//    UserRestServiceController userRestServiceController;

//    @Test
//    void contextLoads() {
//        List<User> users = userRestServiceController.listUser();
//        Assert.isTrue(users.size() > 0);
//    }


    // Rest client Test
    private RestTemplate restTemplate;

//    @Before
//    public void setUp(){
//        HttpClientBuilder builder = HttpClientBuilder.create();
//        CloseableHttpClient httpClient = builder.build();
//        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
//    }

//    @Test
//    public void contextLoads(){
//        String address = "http://localhost:8080/list/users";
//        ResponseEntity<List> entity = restTemplate.getForEntity(address, List.class);
//        List<User> users = entity.getBody();
//    }

//    @Test
//    public void contextLoads(){
//        restTemplate = new RestTemplate();
//        String address = "http://localhost:8080/list/groups";
//        ResponseEntity<Group[]> groupEntity = restTemplate.getForEntity(address, Group[].class);
//        Group[] groups = groupEntity.getBody();
//        Assert.assertTrue(groups.length > 0);
//
//        for (int i = 0; i < groups.length; i++){
//            System.out.println(groups[i].getId());
//        }
//    }

//    @Test
//    public void contextLoads(){
//        restTemplate = new RestTemplate();
//        User user = new User();
//        user.setUsername("test3");
//        user.setPassword("123456");
//        user.setAge(25);
//        user.setGroupId(1);
//        user.setEmail("GHH@gmail.com");
//
//        String address = "http://localhost:8080/add/user";
//        ResponseEntity<String> insertEntity = restTemplate.postForEntity(address, user, String.class);
//        Assert.assertEquals(user.getUsername(), insertEntity.getBody());
//    }

//    @Test
//    public void contextLoads(){
//        restTemplate = new RestTemplate();
//        String address = "http://localhost:8080/get/user/test3";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals("123456",getEntity.getBody().getPassword());
//    }

//    @Test
//    public void contextLoads(){
//        restTemplate = new RestTemplate();
//        String address = "http://localhost:8080/delete/user/test3";
//        restTemplate.delete(address);
//
//        address = "http://localhost:8080/get/user/test3";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
//
//        Assert.assertEquals(null, getEntity.getBody());
//    }

    @Test
    public void contextLoads(){
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/get/user/hoadtph13703";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);

        User user = getEntity.getBody();
        Assert.assertNotNull(user);

        user.setPassword("56789");
        address = "http://localhost:8080/update/user";
        restTemplate.put(address, user);

        address = "http://localhost:8080/get/user/hoadtph13703";
        ResponseEntity<User> getEntity2 = restTemplate.getForEntity(address, User.class);
        Assert.assertEquals(user.getPassword(), getEntity2.getBody().getPassword());
    }

    @Autowired
    private UserRestServiceController userRestServiceController;

}
