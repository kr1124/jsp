package com.chart;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@WebServlet("/XYPlot")
public class XYPlotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = ConnUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "select value from stock";
			
			ResultSet rs = st.executeQuery(sql);
			
			XYSeries vs = new XYSeries("Stock Flow");
			
			int x = 1;
			while (rs.next()) {
				vs.add(x, rs.getInt(1));
				x++;				
			}
			
			XYSeriesCollection ds = new XYSeriesCollection(vs);
			JFreeChart chart = ChartFactory.createXYLineChart(
					"Stock Average", "Day", "Price", ds, PlotOrientation.VERTICAL, true, true, true);
			
			ServletOutputStream out = response.getOutputStream();
			ChartUtilities.writeChartAsPNG(out, chart, 400, 400);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
