INSERT INTO yocy_db.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole) VALUES (1, 'youngcy', 'c67938648308b8f828fafd38d7aba6d6', 'YounGCY', 'https://bu.dusays.com/2023/05/19/6466c62c15757.png', '我有一头小毛驴我一直都在🐔', 'admin');
INSERT INTO yocy_db.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole) VALUES (2, 'youngcy2', 'c67938648308b8f828fafd38d7aba6d6', 'YounGCY2', 'https://bu.dusays.com/2023/05/19/6466c62c15757.png', '我有一头小毛驴我一直都在🐔🐔🐔', 'user');

INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(1, 'ACM 模板项目', 'ACM 模板项目生成器', 'com.yocy', '1.0.0', 'YounGCY', '["Java"]', '', '{}', '{}', null, 0, 1);
INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(2, 'ACM 模板项目1', 'ACM 模板项目生成器222', 'com.yocy', '1.0.0', 'YounGCY', '["Java", "Python"]', '', '{}', '{}', null, 0, 1);
INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(3, 'ACM 模板项目2', 'ACM 模板项目生成器333', 'com.yocy', '1.0.0', 'YounGCY', '["Java", "前端"]', '', '{}', '{}', null, 0, 1);
INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(4, 'ACM 模板项目3', 'ACM 模板项目生成器444', 'com.yocy', '1.0.0', 'YounGCY', '["Java", "算法", "二分"]', '', '{}', '{}', null, 0, 1);
INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(5, 'ACM 模板项目4', 'ACM 模板项目生成器555', 'com.yocy', '1.0.0', 'YounGCY', '["Java"]', '', '{}', '{}', null, 0, 1);

INSERT INTO yocy_db.generator (id, name, description, basePackage, version, author, tags, picture, fileConfig, modelConfig, distPath, status, userId) VALUES(8, 'acm-template-pro-generator', 'ACM 示例模板生成器', 'com.yocy', '1.0.0', 'youngcy', '["Java"]', 'https://yocy-1313941864.cos.ap-shanghai.myqcloud.com/generator_picture/1/r6ErMeFz-wallhaven-614370.jpg', '{
    "files": [
      {
        "groupKey": "git",
        "groupName": "开源",
        "type": "group",
        "condition": "needGit",
        "files": [
          {
            "inputPath": ".gitignore",
            "outputPath": ".gitignore",
            "type": "file",
            "generateType": "static",
            "condition": "needGit"
          },
          {
            "inputPath": "README.md",
            "outputPath": "README.md",
            "type": "file",
            "generateType": "static"
          }
        ]
      },
      {
        "inputPath": "src/com/yocy/acm/MainTemplate.java.ftl",
        "outputPath": "src/com/yocy/acm/MainTemplate.java",
        "type": "file",
        "generateType": "dynamic",
        "group": "post"
      }
    ]
    }', '{"models": [
      {
        "fieldName": "needGit",
        "type": "boolean",
        "description": "是否生成.gitignore文件",
        "defaultValue": true
      },
      {
        "fieldName": "loop",
        "type": "boolean",
        "description": "是否生成循环",
        "defaultValue": false,
        "abbr": "l"
      },
      {
        "groupKey":"mainTemplate",
        "groupName": "核心模板",
        "type": "MainTemplate",
        "description": "用于生成核心模板的文件",
        "condition": "loop",
        "models": [
          {
            "fieldName": "author",
            "type": "String",
            "description": "作者注释",
            "defaultValue": "youngcy",
            "abbr": "a"
          },
          {
            "fieldName": "outputText",
            "type": "String",
            "description": "输出信息",
            "defaultValue": "sum = ",
            "abbr": "o"
          }
        ]
      }
    ]}', '/generator_dist/1/DxYWKZCG-acm-template-pro-generator.zip', 0, 1);