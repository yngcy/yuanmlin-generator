# ${name}

> ${description}
> 
> 作者：${author}
> 
> 基于 [YounGCY](https://github.com/yngcy) 的 [源码林代码生成器项目](https://github.com/yngcy/yuanmlin-generator) 制作，感谢您的使用！

可以通过命令行交互式输入的方式动态生成你想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：

```shell
generator <命令> <参数选项>
```

示例命令：

```bash
generator generate <#list modelConfig.models as modelInfo>-${modelInfo.abbr} </#list>
```

## 参数说明

<#list modelConfig.models as modelInfo>
${modelInfo?index + 1}） ${modelInfo.fieldName}

类型：${modelInfo.type}

描述：${modelInfo.description}

默认值：${modelInfo.defaultValue?c}

缩写：-${modelInfo.abbr}


</#list>