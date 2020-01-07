package proxy;

interface Image {
	public void showImage();
}

class ProxyImage implements Image {
	@Override
	public void showImage() { System.out.println("Template Image"); }
}


class ActualImage implements Image {
	@Override
	public void showImage() { System.out.println("Actual Image"); }
}

class Proxy implements Image {
	
	private Image image;
	
	public Proxy(Image image) {
		this.image = image;
	}
	
	@Override
	public void showImage() {
		if(image == null) {
			new ProxyImage().showImage();
		}
		else {
			image.showImage();
		}
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}




public class TestProxy {
	
	public static void main(String[] args) throws InterruptedException {
		
		Image teddyImage = new ActualImage();
		Image proxyImage = new ProxyImage();
		
		Proxy proxy = new Proxy(proxyImage);
		// start downloading
		proxy.showImage();
		
		Thread.sleep(3000);
		
		proxy.setImage(teddyImage);
		
		proxy.showImage();
	}
}