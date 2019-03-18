package com.pvp.bank.app.bankapi.httpapi;

import com.pvp.bank.app.bankapi.models.HttpReqModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;

@Data
@Service
public abstract class HttpApi<T> {

    @Autowired
    private final HttpReqModel httpReqModel;

    public HttpApi(HttpReqModel httpReqModel) {
        this.httpReqModel = httpReqModel;
    }

    public abstract String createRequest();

    public abstract void addHeaders();

    public abstract T parseResponse(String response);

    public String postRequest(String postParams) throws IOException {

        System.out.println("URL -- " + httpReqModel.getApiUrl());
        System.out.println("Post Parameters -- " + postParams);

        URL url = new URL(httpReqModel.getApiUrl());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setDoOutput(true);

        DataOutputStream outputStreamWriter = new DataOutputStream(urlConnection.getOutputStream());
        outputStreamWriter.writeBytes(postParams);
        outputStreamWriter.flush();
        outputStreamWriter.close();

        System.out.println(" status : " + urlConnection.getResponseCode());
        String response = readResponse(urlConnection);

        return response;
    }

    public String postRequest(String postParams, String certificate) throws Exception {

        System.out.println("URL -- " + httpReqModel.getApiUrl());
        System.out.println("Post Parameters -- " + postParams);

        URL url = new URL(httpReqModel.getApiUrl());
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setDoOutput(true);

        urlConnection.setSSLSocketFactory(createSSlFactory(certificate));

        DataOutputStream outputStreamWriter = new DataOutputStream(urlConnection.getOutputStream());
        outputStreamWriter.writeBytes(postParams);
        outputStreamWriter.flush();
        outputStreamWriter.close();

        System.out.println(" status : " + urlConnection.getResponseCode());
        String response = readResponse(urlConnection);

        return response;
    }

    public String readResponse(HttpURLConnection HttpURLConnection) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(HttpURLConnection.getInputStream()));
        StringBuffer responseContent = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            responseContent.append(inputLine);
        }

        bufferedReader.close();

        return new String(responseContent);
    }

    public String readResponse(HttpsURLConnection HttpsURLConnection) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(HttpsURLConnection.getInputStream()));
        StringBuffer responseContent = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            responseContent.append(inputLine);
        }

        bufferedReader.close();

        return new String(responseContent);
    }

    // Create the and initialize the SSLContext
    protected SSLSocketFactory createSSlFactory(String certificate)
            throws IOException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException,
            UnrecoverableKeyException, KeyManagementException {

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        KeyStore keyStore = KeyStore.getInstance("PKCS12");

        InputStream keyInput = new FileInputStream(certificate);
        keyStore.load(keyInput, null);
        keyInput.close();

        keyManagerFactory.init(keyStore, null);
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());

        return context.getSocketFactory();
    }

    public T getResponseFromAPI() throws Exception {

        if (this.httpReqModel.getCertificate() == null) {
            return parseResponse(postRequest(createRequest()));
        } else if (this.httpReqModel.getCertificate() != null &&
                !this.httpReqModel.getCertificate().equals("") &&
                this.httpReqModel.getApiUrl().toLowerCase().startsWith("https")) {
            return parseResponse(postRequest(createRequest(), httpReqModel.getCertificate()));
        } else {
            throw new Exception("Error Request -- unhandled case ");
        }
    }
}
