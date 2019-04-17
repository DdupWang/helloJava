import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Test {

    /* *
     * @describe:
     * @Param: [s1, s2]
     * @return: java.lang.String
     * @Author: Mr.Wang
     * @Date: 2019/3/28 16:24
     */
    /* *
     * @describe:
     * @Param: [s1, s2]
     * @return: java.lang.String
     * @Author: Mr.Wang
     * @Date: 2019/3/28 16:25
     */
    public String joinStr(String s1,String s2){
        return s1+s2;
    }
    
    public void readXml(String path){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
            Document document=db.parse(path);
            Element root=document.getDocumentElement();
            NodeList nodeList =root.getChildNodes();
            for(int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                if(node.getChildNodes().getLength()>1){
                    NodeList nodeList1=node.getChildNodes();
                    for(int j=0;j<nodeList1.getLength();j++){
                        Node node1=nodeList1.item(j);
                        if(node1.getNodeType()== node1.ELEMENT_NODE ){
                            System.out.println(String.format("<%s>%s<%s>",node1.getNodeName(),node1.getTextContent(),node1.getNodeName()));
                        }
                    }
                }else if(node.getNodeType()==node.ELEMENT_NODE){
                    System.out.println(String.format("<%s>%s<%s>",node.getNodeName(),node.getTextContent(),node.getNodeName()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonstr="{ \"dateSet\":{ \"dateType\":\"D\", \"startDate\":\"20180101\", \"endDate\":\"20180101\" },\n" +
                " \"row\":[ { \"assetId\":\"A229I229005\", \"outputType\":\"\" },{ \"assetId\":\"A22950081\", \"outputType\":\"\" } ],\n" +
                " \"column\":[ { \"assetId\":\"A22950081\", \"aggregate\":\"max\" },\n" +
                " { \"assetId\":\"A22950082\", \"aggregate\":\"min\" },\n" +
                "{ \"assetId\":\"A229F229002\", \"aggregate\":\"count\" },\n" +
                "{ \"assetId\":\"A001\", \"aggregate\":\"sum\" },\n" +
                "{ \"assetId\":\"A001\", \"aggregate\":\"avg\" }], \n" +
                "\"condition\":[ { \"whereAssetId\":\"A001\", \"whereType\":\"<\", \"value\":\"4115110747133363\" } ],\n" +
                "\"sort\":[{\"assetId\":\"A001\",\"sort_type\":2}],\n" +
                "\"preview\":{\"isPreview\":true,\"previewNumber\":6} \n" +
                " \n" +
                "}";
        System.out.println(jsonstr);
    }
}
