package top.humg.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload");
        //使用fileupload组件完成上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("文件夹已创建");

        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> list = upload.parseRequest(request);
        for (FileItem fileItem : list) {
            //进行判断，当前item对象是否是上传文件项
            if (fileItem.isFormField()) {
                System.out.println("表单项");
            } else {
                String filename = fileItem.getName();
                String uuid = UUID.randomUUID().toString();
                System.out.println(uuid);
                filename = uuid + "_" + filename;
                //完成文件上传
                System.out.println("文件已上传");
                fileItem.write(new File(path, filename));
                fileItem.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileUpload2");
        //使用fileupload组件完成上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("文件夹已创建");

        }

        //获取文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        //使文件名唯一
        filename = uuid + "_" + filename;
        //完成文件上传
        System.out.println("文件已上传");
        upload.transferTo(new File(path, filename));
        return "success";
    }

    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("fileUpload3");
        //定义图片服务器地址
        String path = "http://localhost:8080/uploads/";

        //获取文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        //使文件名唯一
        filename = uuid + "_" + filename;

        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传文件（文件的字节码数组）
        resource.put(upload.getBytes());
        //完成文件上传
        System.out.println("文件已上传至图片服务器");

        return "success";
    }
}
