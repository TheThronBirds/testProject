package only.luzejin.webservice.test;

/**
 * ������only.luzejin.webservice
 * ������MyTestWebService
 * ������ TODO
 * ������luzejin
 * ����ʱ��2019/7/31 0:18
 **/
public class test {


    public static void main(String[] args) {
        test myTestWebService = new test();
        myTestWebService.testWebService();
    }

    public void testWebService(){
        //��ȡwebservice�����������������������ʵ�Ǵ�wsdl�ļ��е�servicename��ǩ�н��л�ȡ�ģ�
        MyFirstWebServiceService myFirstWebServiceService = new MyFirstWebServiceService();
        //��ȡ�������Զ����webservice�Ķ���
        MyFirstWebService myFirstWebServicePort = myFirstWebServiceService.getMyFirstWebServicePort();
        //����service�������еķ���
        String receivedInfo = myFirstWebServicePort.testWebService("���ã�webservice ������");
        //��ӡ�ӷ������ķ����еõ��ķ���ֵ�����Ա�ʾ�յ��˷��������ص�����
        System.out.println("���������ص������ǣ�" + receivedInfo);
    }
}
