package com.sanket.ipropel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "FILE")
public class File {
	
	@Id
	@GeneratedValue
	@Column(name = "FILEID")
	private int fileId;
	
	@Column(name = "FILENAME")
	private String fileName;
	
	@Column(name = "FILEPATH")
	private String filePath;
	
	@Transient
	private MultipartFile file;
	/**
	 * Default Constructor
	 */
	public File() {
	}
	/**
	 * @param fileName
	 * @param filePath
	 * @param file
	 */
	public File(String fileName, String filePath, MultipartFile file) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.file = file;
	}
	/**
	 * @return the fileId
	 */
	public int getFileId() {
		return fileId;
	}
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
