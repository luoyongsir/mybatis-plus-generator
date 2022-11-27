package com.nice.sboot.generator;

import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 配置对应数据源，表，路径
 * 运行 main 方法生成对应表的代码
 *
 * @author 罗勇
 * @date 2022/1/17
 */
public class GeneratorMain {

	/**
	 * mysql,oracle,sqlserver
	 */
	private static final String DB_TYPE = "mysql";

	public static void main(String[] args) {
		// @formatter:off

		// 输出路径，配置到 main 路径
		String baseDir = "C:\\Workspace\\xxx\\src\\main\\";

		// 数据库配置
		String url = "jdbc:mysql://127.0.0.1:3306/nice";
		String username = "root";
		String password = "xxx";
		DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(url, username, password).build();

		// 全局配置
		GlobalConfig globalConfig = new GlobalConfig.Builder()
				.outputDir(baseDir + "java")
				.author("罗勇")
				.disableOpenDir()
//				.enableSwagger()
				.enableSpringdoc()
				.dateType(DateType.TIME_PACK)
				.commentDate("yyyy-MM-dd")
				.build();

		// 包配置
		PackageConfig packageConfig = new PackageConfig.Builder()
				.parent("com.xxx.xxx")
				.entity("model.entity")
				.service("service")
				.serviceImpl("service.impl")
				.mapper("mapper")
				.xml("Mapper.xml")
				.controller("controller")
				.pathInfo(Collections.singletonMap(OutputFile.xml, baseDir + "resources\\mapper\\" + DB_TYPE))
				.build();

		StrategyConfig strategyConfig = new StrategyConfig.Builder()
				.enableCapitalMode()
				.enableSkipView()
				.addTablePrefix("t_")
//				.addInclude("t_xx_xxx")
				.likeTable(new LikeTable("t_", SqlLike.RIGHT))
				.build()
				.entityBuilder()
				.enableFileOverride()
				.enableLombok()
				.enableChainModel()
				.logicDeleteColumnName("del_flag")
				.logicDeletePropertyName("delFlag")
				.superClass(packageConfig.joinPackage(packageConfig.getEntity()) + ".BaseEntity")
				.addSuperEntityColumns("id", "del_flag", "create_by", "create_time", "update_by", "update_time")
				.build()
				.controllerBuilder()
				.enableFileOverride()
				.enableRestStyle()
				.enableHyphenStyle()
				.build()
				.mapperBuilder()
				.enableFileOverride()
				.build()
				.serviceBuilder()
				.enableFileOverride()
				.formatServiceFileName("%sService")
				.build();

		TemplateConfig templateConfig = new TemplateConfig.Builder()
				.entity("entity.java")
				.build();

		AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig)
				.global(globalConfig).packageInfo(packageConfig).strategy(strategyConfig)
				.template(templateConfig);

		autoGenerator.execute(new FreemarkerTemplateEngine());

		// @formatter:on
	}
}
