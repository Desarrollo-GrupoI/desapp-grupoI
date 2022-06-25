package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;

public class UserVolumeDTO {
	private User user;
	private LocalDateTime date;
	private Float totalDollarPrice;
	private Float totalPesosPrice;
	private List<CryptoActiveDTO> cryptoActives;
	
	public UserVolumeDTO(User user, LocalDateTime date, Float totalDollarPrice, Float totalPesosPrice,
			List<CryptoActiveDTO> cryptoActives) {
		this.user = user;
		this.date = date;
		this.totalDollarPrice = totalDollarPrice;
		this.totalPesosPrice = totalPesosPrice;
		this.cryptoActives = cryptoActives;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Float getTotalDollarPrice() {
		return this.totalDollarPrice;
	}

	public void setTotalDollarPrice(Float totalDollarPrice) {
		this.totalDollarPrice = totalDollarPrice;
	}

	public Float getTotalPesosPrice() {
		return this.totalPesosPrice;
	}

	public void setTotalPesosPrice(Float totalPesosPrice) {
		this.totalPesosPrice = totalPesosPrice;
	}

	public List<CryptoActiveDTO> getCryptoActives() {
		return this.cryptoActives;
	}

	public void setCryptoActives(List<CryptoActiveDTO> cryptoActives) {
		this.cryptoActives = cryptoActives;
	}
}
