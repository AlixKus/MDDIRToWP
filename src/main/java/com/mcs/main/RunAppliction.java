package com.mcs.main;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.mcs.filePrase.PraseDictoryService;
import com.mcs.service.catalogService;
import com.mcs.service.postService;
import com.mcs.service.relationshipService;

public class RunAppliction {
	catalogService cs = new catalogService();
	postService ps = new postService("http://59.110.162.40/?p=");
	relationshipService rs = new relationshipService();
	Path rootLocation = Paths.get("E:\\study");

	public void run()
	{
		try {
			new PraseDictoryService(rootLocation, cs, ps, rs).Parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		System.out.println("End");
	}
	
	public static void main(String[] args) {
		new RunAppliction().run();
	}
}
