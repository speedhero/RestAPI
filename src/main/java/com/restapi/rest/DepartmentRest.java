package com.restapi.rest;

import com.restapi.service.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("dept")
public class DepartmentRest {

    /*
        Jersey1.x�汾 ����
        Caused by: com.sun.jersey.api.client.ClientHandlerException: A message body writer for Java type, class com.spring.jersy.jpa.hibernate.model.User, and MIME media type, application/json, was not found
        ���쳣ͨ��������ԭ��

        1��ǰ������ô�ֵ�ͷ���ֵ�����ݸ�ʽ��JSON�����ǰ�˲�����JSON��ֵ���ᱨ�ô���Jersey����Spring��ǰ�˽�����ǰ����Ҫ��ֵת����JSON�󣬲��ܴ��ݣ�����Struts2��Spring MVC�ܹ�������Ĭ��ʵ�֡�

        2�������˲�����JSON����ֵ��Ҳ�ᱨ���쳣����Ҫͨ��JSONArray����JSONObjectת����JSON���ݣ�����ǰ��˴�ֵ���ݸ�ʽһ��Ҫһ�¡�

        3��Jersey���ض���ֵʱ����Ҫ��ʵ�����ϼ���@XmlRootElement(name="user")��name��������ȡ�����ظ����ɣ�ͨ������������ĸСд��
*/
    /*
    *  1��@GET��ǩ��˵������Դ������ʹ��get��ʽ����
    *  2��@Produces��ǩ���������Դ������������ӦMIME��ʽΪapplication/json��
    *  3��@Consumes��ǩ���������Դ�����ܹ���������MIME����Ϊapplication/json��
    *  4���ڷ����У�ֱ�ӷ���department������б�
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

    /*�ϲ���������ͨ��������Դ���������JSON��XML��ʽ�������������ʵJersey���ṩ�˸�����ķ�ʽ�������δ���ϲ�������*/
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
        System.out.println("ɾ�����ţ�" + id);
    }
}
