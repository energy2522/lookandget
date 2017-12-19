package com.lookandget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Володимир Майборода on 16.12.2017.
 */

public final class MainUtils {

    public static boolean isSuccessSign(final String urlString, String json) {
        try  {
            StringBuilder stringBuilder = null;
            URL url = new URL(urlString);

            System.out.println(url.toString());

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);

            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream())){
                System.out.println(json);
                outputStreamWriter.write(json);
                outputStreamWriter.close();
            } catch (Exception e) {
                System.out.println("Error in OutputStream!!!");
                e.printStackTrace();
                return false;
            }

            try (InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream())){
                BufferedReader reader = new BufferedReader(inputStream);
                stringBuilder = new StringBuilder();
                String str;
                while ((str = reader.readLine()) != null) {
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(str).append("\n");
                    }

                }
            } catch (Exception e) {
                System.out.println("Error in InputStream!!!");
                e.printStackTrace();
                return false;
            }

            System.out.println(stringBuilder.toString());

            if (stringBuilder.toString().equals("success")) {
                return true;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isSuccessOut(final String urlString) {
        try {
            StringBuilder stringBuilder = null;
            URL url = new URL(urlString);

            System.out.println(url.toString());


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(50000);
            urlConnection.setReadTimeout(50000);

            try (InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream())){
                BufferedReader reader = new BufferedReader(inputStream);
                stringBuilder = new StringBuilder();
                String str;
                while ((str = reader.readLine()) != null) {
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(str).append("\n");
                    }

                }
            } catch (Exception e) {
                System.out.println("Error in InputStream!!!");
                e.printStackTrace();
                return false;
            }

            System.out.println(stringBuilder.toString());

            if (stringBuilder.toString().equals("success")) {
                return true;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
