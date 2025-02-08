// Adapter Pattern 

enum Port{
    USB_A , USB_C , SD_CARD ;
}

class SDCard{
    private String info;
    private static Port port = Port.SD_CARD;
    public SDCard(String info){
        this.info = info;
    }
    public void read(){
        System.out.println("Reading from SD card: " + info);
    }
}

interface PenDrive{
    void read();
}

class SDCardReader implements PenDrive{
    private SDCard sdCard;
    public SDCardReader(SDCard sdCard){
        this.sdCard = sdCard;
    }
    @Override
    public void read() {
        sdCard.read();
    }

}

class USBJack{
    private PenDrive pd;
    private static Port port = Port.USB_A;
    public USBJack(PenDrive pd){
        this.pd = pd;
    }

    public void accessData(){
        pd.read();
    }
}

public class Main {
    public static void main(String[] args) {
    SDCard sdCard = new SDCard("Information encrypted in SD card ");
    PenDrive pd = new SDCardReader(sdCard);
    USBJack jack = new USBJack(pd);
    jack.accessData();
    }
}