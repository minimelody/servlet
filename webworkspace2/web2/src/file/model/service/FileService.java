package file.model.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDao;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

public class FileService {

	public int uploadFile(DataFile df) {
		Connection conn = JDBCTemplate.conn();
		int result = new FileDao().uploadFile(conn,df);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<DataFile> listFile() {
		Connection conn = JDBCTemplate.conn();
		ArrayList<DataFile> list = new FileDao().listFile(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public DataFile fileSelectDownload(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.conn();
		DataFile df = new FileDao().fileSelectDownload(conn, fileName, uploadTime);
		JDBCTemplate.close(conn);
		return df;
	}

	public int uploadFile2(DataFile2 df2) {
		Connection conn = JDBCTemplate.conn();
		int result = new FileDao().uploadFile(conn, df2);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<DataFile2> listFile2() {
		Connection conn = JDBCTemplate.conn();
		ArrayList<DataFile2> list = new FileDao().listFile2(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public DataFile2 fileSelectDownload2(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.conn();
		DataFile2 df2 = new FileDao().fileSelectDownload2(conn, fileName, uploadTime);
		JDBCTemplate.close(conn);
		return df2;
	}

	public int deleteFile(String fileName) {
		Connection conn = JDBCTemplate.conn();
		int result = new FileDao().deleteFile(conn, fileName);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	
}
