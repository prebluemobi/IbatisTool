package org.roundface.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.roundface.model.Tabel;
import org.roundface.util.ConnetionUtils;
import org.roundface.util.DateUtils;
import org.roundface.util.GenerateReader;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MybatisGenerator {
	public static String AUTHOR="";
	public static String PROJECT_NAME="";
	public static String TITLE="";
	public static String DATE="";
	public static String PACKAGE="";		
	public static String PROJECT_URL = GenerateReader.getInstance().getProperty("project_name");
	public static String SOURCE_URL = GenerateReader.getInstance().getProperty("source_name");
	public static String DATA_URL = GenerateReader.getInstance().getProperty("data_package_name");
	public static String SERVICES_URL = GenerateReader.getInstance().getProperty("service_package_name");
	public static String CONTROLLER_URL = GenerateReader.getInstance().getProperty("controller_package_name");	
	
	
	public void gener(String[] tables) throws Exception {
		String[] types = { "TABLE" };
		Configuration cfg = new Configuration();
		//cfg.setClassForTemplateLoading(MybatisGenerator.class, "/templates");
		cfg.setDirectoryForTemplateLoading(new File("./resource/templates"));
		Connection jdbcConnection = ConnetionUtils.getConnetion();
		for (String table : tables) {
			List<Tabel> l = ConnetionUtils.getTables(jdbcConnection, types,
					table);
			for (Tabel t : l) {
				System.out.println(t.getTabelName());
				System.out.println("----------------------------");
				generateData(cfg, t);
				generateInterface(cfg, t, t.getVarName());
				//generateListJsp(cfg, t, t.getTabelName());
			}
		}
	}

	public static void generateData(Configuration cfg, Tabel t)
			throws IOException, TemplateException {
								
		
		String modelPath = PROJECT_URL + SOURCE_URL + DATA_URL + "model";
		Template temp = cfg.getTemplate("model_temp.ftl");
		//String outdir = getPath() + "/data" + "/model/system";
		String outdir = modelPath;
		String outfile = t.getClassName() + ".java";
		generate(t, temp, outfile, outdir);

		String daoPath = PROJECT_URL + SOURCE_URL + DATA_URL + "dao";
		Template temp2 = cfg.getTemplate("dao_temp.ftl");
		//String outdir2 = getPath() + "/data" + "/dao/system";
		String outdir2 = daoPath;
		String outfile2 = t.getClassName() + "Dao.java";
		generate(t, temp2, outfile2, outdir2);

		String daoImplPath = PROJECT_URL + SOURCE_URL + DATA_URL + "dao/impl";
		Template temp1 = cfg.getTemplate("daoImpl_temp.ftl");
		//String outdir1 = getPath() + "/data" + "/dao/system/impl";
		String outdir1 = daoImplPath;
		String outfile1 = t.getClassName() + "DaoImpl.java";
		generate(t, temp1, outfile1, outdir1);

		String mapperPath = PROJECT_URL + SOURCE_URL + DATA_URL + "mapper";
		Template temp3 = cfg.getTemplate("mapper_temp.ftl");
		//String outdir3 = getPath() + "/data" + "/mapper/system";
		String outdir3 = mapperPath;
		String outfile3 = t.getClassName() + "Mapper.xml";
		generate(t, temp3, outfile3, outdir3);
	}

	public static void generateInterface(Configuration cfg, Tabel t,
			String domain) throws IOException, TemplateException {

		String controllerPath = PROJECT_URL + SOURCE_URL + CONTROLLER_URL + "back";
		Template temp2 = cfg.getTemplate("controller_temp.ftl");
		//String outdir2 = getPath() + "/" + domain + "/controller";
		String outdir2 = controllerPath;
		String outfile2 = t.getClassName() + "Controller.java";
		generate(domain, t, temp2, outfile2, outdir2);

		String servicePath = PROJECT_URL + SOURCE_URL + SERVICES_URL;
		Template temp3 = cfg.getTemplate("service_temp.ftl");
		//String outdir3 = getPath() + "/" + domain + "/service";
		String outdir3 = servicePath;
		String outfile3 = t.getClassName() + "Service.java";
		generate(domain, t, temp3, outfile3, outdir3);

		String serviceImplPath = PROJECT_URL + SOURCE_URL + SERVICES_URL + "impl";
		Template temp4 = cfg.getTemplate("serviceImpl_temp.ftl");
		//String outdir4 = getPath() + "/" + domain + "/service/impl";
		String outdir4 = serviceImplPath;
		String outfile4 = t.getClassName() + "ServiceImpl.java";
		generate(domain, t, temp4, outfile4, outdir4);

	}

	public static void generateListJsp(Configuration cfg, Tabel t, String domain)
			throws IOException, TemplateException {

		String path = getPath();
		Template temp = cfg.getTemplate("jsp_list_temp.ftl");
		String outdir = path + "/views/" + t.getVarName() + "/";
		String outfile = domain+"_list.jsp";
		generate(domain, t, temp, outfile, outdir);

		Template temp1 = cfg.getTemplate("jsp_detailed_temp.ftl");
		String outfile1 = "detailed.jsp";
		generate(domain, t, temp1, outfile1, outdir);

	}

	public static void generate(String domain, Tabel t, Template temp,
			String outfilename, String outdir) throws IOException,
			TemplateException {
		File f = new File(outdir);
		f.mkdirs();
		File fn = new File(f.getPath() + "/" + outfilename);
		fn.createNewFile();
		FileOutputStream fos = new FileOutputStream(fn);
		Writer out = new OutputStreamWriter(fos);
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("table", t);
		root.put("domain", domain);
		root.put("date", DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		root.put("author", AUTHOR);
		root.put("projectName", PROJECT_NAME);
		root.put("title", TITLE);
		root.put("date", DATE);
		root.put("dd", "$");
		root.put("package", PACKAGE);
		temp.process(root, out);
		out.flush();
		out.close();
	}

	public static void generate(Tabel t, Template temp, String outfilename,
			String outdir) throws IOException, TemplateException {
		generate("", t, temp, outfilename, outdir);
	}

	public static String getPath() throws FileNotFoundException {
		String path = MybatisGenerator.class.getResource("/").getPath();

		File s = new File(path).getParentFile();
		String n = s.getPath() + "/out/";
		File f = new File(n);
		if (f.exists()) {
			f.delete();
		}
		return f.getPath();

	}
}
