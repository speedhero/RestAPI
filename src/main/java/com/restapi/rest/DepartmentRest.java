package com.restapi.rest;

import com.restapi.service.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("dept")
public class DepartmentRest {

    /*
        Jersey1.x版本 问题
        Caused by: com.sun.jersey.api.client.ClientHandlerException: A message body writer for Java type, class com.spring.jersy.jpa.hibernate.model.User, and MIME media type, application/json, was not found
        这异常通常有三种原因：

        1、前后端设置传值和返回值的数据格式是JSON，如果前端不是以JSON传值，会报该错误。Jersey整合Spring与前端交互，前端需要将值转换成JSON后，才能传递，不像Struts2或Spring MVC能够替我们默认实现。

        2、如果后端不是以JSON返回值，也会报此异常，需要通过JSONArray或者JSONObject转换成JSON数据，所以前后端传值数据格式一定要一致。

        3、Jersey返回对象值时，需要在实体类上加上@XmlRootElement(name="user")，name可以任意取，不重复即可，通常是类名首字母小写。
*/
    /*
    *  1，@GET标签：说明该资源方法是使用get方式请求；
    *  2，@Produces标签：代表该资源方法生产的响应MIME格式为application/json；
    *  3，@Consumes标签：代表该资源方法能够接受请求MIME类型为application/json；
    *  4，在方法中，直接返回department对象的列表；
    * */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Department> list() {
        List<Department> dept = new ArrayList();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

   /* @GET
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public List<Department> listXml() {
        List<Department> dept = new ArrayList();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }*/

    /*合并，我们是通过两个资源方法来完成JSON和XML格式的内容输出，其实Jersey中提供了更合理的方式，把两段代码合并起来：*/
/*    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Department> listAll() {
        List<Department> dept = new ArrayList();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }*/


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_XML)
    public Department get(@PathParam("id") Long id) {
        return new Department(id, "dept2");
    }

    @POST //2
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_XML)
    public Department save(@FormParam("name") String name) {
        Department d = new Department(1L, name);
        return d;
    }

    @PUT //3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_XML)
    public Department update(@PathParam("id") Long id, @FormParam("name") String name) {
        Department d = new Department(id, name);
        return d;
    }

    @DELETE //4
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void delete(@PathParam("id") Long id) {
        System.out.println("删除部门：" + id);
    }
}
