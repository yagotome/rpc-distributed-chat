package rmigroupchat.model;

public class Config {
	private String rmiRegistryHost;
	private int rmiRegistryPort;
	private String multicastAddress;
	private int socketPort;
		
	public int getSocketPort() {
		return socketPort;
	}

	public int getRmiRegistryPort() {
		return rmiRegistryPort;
	}

	public void setRmiRegistryPort(int rmiRegistryPort) {
		this.rmiRegistryPort = rmiRegistryPort;
	}

	public void setSocketPort(int socketPort) {
		this.socketPort = socketPort;
	}

	public String getMulticastAddress() {
		return multicastAddress;
	}

	public void setMulticastAddress(String multicastAddress) {
		this.multicastAddress = multicastAddress;
	}

	public String getRmiRegistryHost() {
		return rmiRegistryHost;
	}

	public void setRmiRegistryHost(String rmiRegistryHost) {
		this.rmiRegistryHost = rmiRegistryHost;
	}
}
