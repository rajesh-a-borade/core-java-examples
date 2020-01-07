package adapter;

interface VideoPlayer { // can play video files as well
	void playFile();
}

class MpegPlayer implements VideoPlayer {

	@Override
	public void playFile() {
		System.out.println("MpegPlayer video player ");
	}
}

interface AudioPlayer { // only meant for audio files
	void play();
}

class Mp3Player implements AudioPlayer {

	@Override
	public void play() {
		System.out.println("Mp3Player audio player ");
	}
}

class AudioAdapter implements AudioPlayer {

	private VideoPlayer videoPlayer;
	
	public AudioAdapter(VideoPlayer videoPlayer) {
		this.videoPlayer = videoPlayer;
	}
	
	@Override
	public void play() {
		System.out.println("Streaming only Audio...");
		videoPlayer.playFile();
	}
}

// class ChildAudioAdapter extends AudioAdapter {}

public class TestAdapter {

	public static void main(String[] args) {
		
		VideoPlayer mpegPlayer = new MpegPlayer();
		AudioPlayer audioPlayer = new Mp3Player();
		
		mpegPlayer.playFile();
		audioPlayer.play();
		
		AudioPlayer videoAsAudioPlayer = new AudioAdapter(mpegPlayer); 
		videoAsAudioPlayer.play();
		
	}
}
