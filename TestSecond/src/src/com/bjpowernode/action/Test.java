package src.com.bjpowernode.action;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Test {

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    static {
        _i = 1;
    }
    public static int        _i       = 0;

    public void stest() {
        // executor.scheduleWithFixedDelay(arg0, arg1, arg2, arg3)
    }

    public static void main(String[] args) {
        System.out.println(_i);
        // new Student();
    }

    // public void pdfToImageToPdf(String sourceFilePath, String desFilePath){
    // File file = new File(sourceFilePath);
    // Document docOut = new Document();
    // docOut.setMargins(0, 0, 0, 0);
    // int fileSize=0;
    // try {
    // FileOutputStream os = new FileOutputStream(desFilePath);
    // PdfWriter.getInstance(docOut, os);
    // docOut.open();
    // PDDocument doc = PDDocument.load(file);
    // PDFRenderer renderer = new PDFRenderer(doc);
    // int pageCount = doc.getNumberOfPages();
    // for(int i=0; i<<span class="s2">pageCount; i++){
    // long t1 = System.currentTimeMillis();
    // ByteArrayOutputStream bb = new ByteArrayOutputStream();
    // BufferedImage image = renderer.renderImage(i, 3f); //第二个参数越大生成图片分辨率越高。
    // // BufferedImage image = renderer.renderImageWithDPI(i, 300); //第二个参数越大生成图片分辨率越高。
    //
    // System.out.println(image.getHeight()+"------"+image.getWidth());
    // long t2 = System.currentTimeMillis();
    // ImageIO.write(image, "jpg",bb );
    // // ImageIOUtil.writeImage(image, "jpg", (OutputStream)bb,300,1f);
    //
    // fileSize=fileSize+bb.size();
    //
    // long t3 = System.currentTimeMillis();
    // Image jpg = Image.getInstance(bb.toByteArray());
    // long t4 = System.currentTimeMillis();
    // // jpg.scalePercent(50); //此处百分比与前面的分辨率参数相乘结果为1，则可保证等比输出。
    //
    // float imageHeight = jpg.scaledHeight();
    // float imageWidth = jpg.scaledWidth();
    // int dalt = 0;
    // while (imageHeight > 1200 || imageWidth > 600) {
    // jpg.scalePercent(100 - dalt);
    // dalt++;
    // imageHeight = jpg.scaledHeight();
    // imageWidth = jpg.scaledWidth();
    // System.out.println("imageHeight->" + imageHeight);
    // System.out.println("imageWidth->" + imageWidth);
    // }
    // jpg.setAlignment(Image.ALIGN_CENTER);
    // docOut.add(jpg);
    // long t5 = System.currentTimeMillis();
    // System.out.println((t2 - t1) + "***" + (t3 - t2) + "***" + (t4 - t3) + "***" + (t5 - t4));
    // }
    // System.out.println("size="+fileSize);
    // docOut.close();
    // }catch (FileNotFoundException e){
    // e.printStackTrace();
    // }catch (DocumentException e){
    // e.printStackTrace();
    // }catch (IOException e){
    // e.printStackTrace();
    // }
    // }
}

class People1 {

    static {
        System.out.println("父静");
    }
    {
        System.out.println("fuchushihua");
    }

    public People1(){
        System.out.println("fu gou");
    }
}

class Student1 extends People1 {

    static {
        System.out.println("zi静");
    }
    {
        System.out.println("zi chushihua");
    }

    public Student1(){
        System.out.println("zi gou");
    }

}
