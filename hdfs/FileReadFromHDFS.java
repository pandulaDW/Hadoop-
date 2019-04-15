package com.hadoop.test_1.hdfs;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileReadFromHDFS {

	public static void main(String[] args) throws Exception {
		
		// File to read in HDFS 
		String uri = args[0]; 
		Configuration conf = new Configuration(); 
		
		// Get the filesystem HDFS
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		FSDataInputStream in = null; 
		
		try {
			// Open the path mentioned in HDFS
			in = fs.open(new Path(uri)); 
			IOUtils.copyBytes(in, System.out, 4096, false);
			
			System.out.println("\r\n##End of file: HDFS file read complete");
			
		} finally {
			IOUtils.closeStream(in);
		}

	}

}
