# 本地文件导入到Wordpress数据库
# 使用方法
## 修改 /MDDIRToWP/src/main/resources/config.properties
root MD文件目录
guidprefix 文章网站guid前缀
## 配置数据库连接 修改/MDDIRToWP/src/main/resources/config/dataSource.properties
jdbcUrl 为你的数据库url 注意要加上useUnicode=true&characterEncoding=utf8，否则中文会乱码
username 为你的数据库用户名
password 为你的数据库密码