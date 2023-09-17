package Cucumber.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.NotFoundException;

import com.google.gson.Gson;

import Cucumber.managers.FileReaderManager;
import Cucumber.testDataTypes.Data;


public class JsonDataReader {
	private final String clientFilePath=FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()+"Data.json";
	private List<Data> clientList;
	
	public JsonDataReader()
	{
		clientList=getClientData();
	}
	private List<Data> getClientData()
	{
		Gson gson=new Gson();
		BufferedReader bufferReader=null;
		try
		{
			bufferReader=new BufferedReader(new FileReader(clientFilePath));
			Data[] clients=gson.fromJson(bufferReader, Data[].class);
			return Arrays.asList(clients);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException("json file not found at path:"+clientFilePath);
		}finally {
			try
			{
				if(bufferReader!=null) bufferReader.close();
				
			}catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	public final Data getClientbyAutomationId(String string) {
		try {
			for(Data client:clientList) {
				System.out.println(string);
				if(client.cardAutomationId.equals(string)) return client;
			}
			return null;
		}catch (NotFoundException e) {
			// TODO: handle exception
			throw new NotFoundException("cardAutomation ID not found"+clientFilePath);
		}
	}
//	public static void main(String[] args) {
//		
//		JsonDataReader json=new JsonDataReader();
//		System.out.println(json.getClientbyAutomationId("Card1").credentials.clientcardNumber);
//	}

}
