package only.luzejin.webservice.test;

/**
 * 包名称only.luzejin.webservice
 * 类名称MyTestWebService
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/7/31 0:18
 **/
public class test {


    public static void main(String[] args) {
        test myTestWebService = new test();
        myTestWebService.testWebService();
    }

    public void testWebService(){
        //获取webservice服务器对象（这里的类名，其实是从wsdl文件中的servicename标签中进行获取的）
        MyFirstWebServiceService myFirstWebServiceService = new MyFirstWebServiceService();
        //获取到我们自定义的webservice的对象
        MyFirstWebService myFirstWebServicePort = myFirstWebServiceService.getMyFirstWebServicePort();
        //调用service服务器中的方法
        String receivedInfo = myFirstWebServicePort.testWebService("您好，webservice 服务器");
        //打印从服务器的方法中得到的返回值，测试表示收到了服务器返回的内容
        System.out.println("服务器返回的内容是：" + receivedInfo);
    }
}
