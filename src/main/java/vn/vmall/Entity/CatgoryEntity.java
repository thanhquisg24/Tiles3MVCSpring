package vn.vmall.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CatgoryEntity {
	@Override
	public String toString() {
		return "CatgoryEntity [id=" + id + ", img=" + img + ", name=" + name
				+ "]";
	}

	@Column(name="id")
	private String id;

	@Column(name="img")
	private String img;

	@Column(name="name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
