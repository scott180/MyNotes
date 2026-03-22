# vue笔记

## 教程

https://www.trae.com.cn
https://cursor.com/cn
https://code.visualstudio.com


Vue.js 是什么
https://v2.cn.vuejs.org/v2/guide/index.html


菜鸟教程 
模板语法 https://www.runoob.com/vue2/vue-template-syntax.html
组件  https://www.runoob.com/vue2/vue-component.html

vue中使用 $emit(eventName) 触发事件，使用 $on(eventName) 监听事件


Vue 2 与 Vue 3 的区别
https://cloud.tencent.com/developer/article/2621362



## 安装

```js

# 1. 安装 Node.js 18（LTS）
nvm install 18

# 2. 使用 Node.js 18
nvm use 18

# 3. 设置为默认版本
nvm alias default 18

# 4. 验证
node -v  # 输出 v18.x.x
npm -v   # 输出对应 npm 版本


# 设置新淘宝镜像
npm config set registry https://registry.npmmirror.com

# 清理缓存和依赖
npm cache clean --force
rm -rf node_modules package-lock.json

# 重新安装（带 legacy 和 verbose 查看进度）
npm install --legacy-peer-deps --verbose

npm install --verbose --registry https://registry.npmmirror.com --legacy-peer-deps


# 关闭无用功能
npm config set audit false
npm config set fund false

# （可选）安装 pnpm 获得更快体验
npm install -g pnpm
pnpm set registry https://registry.npmmirror.com


# 一次性安装所有开发依赖（loader + svg-baker-runtime）
npm install --save-dev svg-sprite-loader cache-loader vue-style-loader css-loader vue-loader@15 svg-baker-runtime




# 安装服务
npm install   
或 pnpm install ( 需要 nvm use 18)

npm下载相当慢，pnpm下载速度快的多。

清理 pnpm 残留，回到项目根目录，手动删除以下内容：
	node_modules/.pnpm 文件夹（如果单独存在）
	若有 pnpm-lock.yaml 文件，直接删除

# 启动服务
npm run dev

```



## 模板语法

Vue.js 的模板语法是一种基于 HTML 的扩展语法，它允许开发者声明式地将 DOM 绑定到底层 Vue 实例的数据上。简单来说，就是用简洁的指令告诉 Vue “**当数据变化时，视图应该如何更新**”。



结合你提供的参考材料，我为你梳理了 Vue 模板语法的核心体系，主要分为**插值**、**指令**、**用户输入**和**缩写**四个部分。

### 1. 插值 (Interpolation)
这是数据绑定最基本的形式，用于将数据渲染到 DOM 中。

*   **文本插值 (Mustache 语法)**
    使用双大括号 `{{ }}` 将 Vue 实例 `data` 中的属性值渲染为文本。
    *   **语法：** `{{ message }}`
    *   **特点：** 数据更新时，插值处的内容会自动更新。

*   **HTML 插值**
    如果需要输出真正的 HTML 代码（而非纯文本），需要使用 `v-html` 指令。
    *   **语法：** `<div v-html="content"></div>`
    *   **注意：** 这会直接替换元素的 innerHTML，需注意 XSS 攻击风险。

*   **属性插值**
    普通 HTML 属性无法使用 `{{ }}`，必须使用 `v-bind` 指令。
    *   **语法：** `<img v-bind:src="imageSrc" />`
    *   **用途：** 绑定 class、style、href、src 等 HTML 属性。

*   **JavaScript 表达式**
    在 `{{ }}` 或指令中，可以使用简单的 JavaScript 表达式。
    *   **示例：** `{{ number + 1 }}`、`{{ ok ? 'YES' : 'NO' }}`、`{{ message.split('').reverse().join('') }}`。

### 2. 指令 (Directives)
指令是带有 `v-` 前缀的特殊属性，用于在 DOM 上应用**副作用**（即当表达式改变时，响应式地作用于 DOM）。

*   **参数 (Arguments)**
    指令后通过冒号 `:` 指明参数，用于监听特定的 DOM 事件或属性。
    *   **示例：** `v-bind:href`（响应式更新 href 属性）、`v-on:click`（监听点击事件）。

*   **常用指令概览**

| 指令 | 用途 | 说明 |
| :--- | :--- | :--- |
| **v-if** | 条件渲染 | 根据表达式的真假值，决定元素是否插入 DOM。 |
| **v-for** | 列表渲染 | 基于数组或对象渲染列表（循环）。 |
| **v-on** | 事件监听 | 绑定事件监听器，触发方法调用。 |
| **v-model** | 双向绑定 | 在表单控件（input, textarea 等）上创建双向数据绑定（详见下文）。 |
| **v-bind** | 属性绑定 | 响应式地绑定 HTML 属性。 |

*   **修饰符 (Modifiers)**
    以半角句号 `.` 指明的特殊后缀，用于指示指令以特殊方式绑定。
    *   **示例：** `v-on:submit.prevent="onSubmit"`。这里的 `.prevent` 修饰符会自动调用 `event.preventDefault()`，阻止表单默认提交行为。

### 3. 用户输入与双向绑定
Vue 提供了专门的机制来处理用户交互。

*   **v-model 指令**
    这是 Vue 实现**双向数据绑定**的核心指令。
    *   **原理：** 它会自动同步表单元素（如 input、select、checkbox）的值与 Vue 实例中的数据。
    *   **场景：** 当用户在输入框输入内容时，Vue 实例的数据会自动更新；反之，数据更新也会立即反映在输入框中。

*   **事件处理 (v-on)**
    使用 `v-on:事件名` 来监听 DOM 事件，并在触发时执行 Vue 实例中的方法（`methods`）。
    *   **示例：** `<button v-on:click="reverseMessage">反转</button>`。

### 4. 过滤器 (Filters)
用于常见的文本格式化。过滤器只能在双大括号插值和 `v-bind` 表达式中使用。

*   **语法：** 使用管道符 `|` 链接。
*   **示例：** `{{ message | capitalize }}`
*   **串联：** 可以同时使用多个过滤器：`{{ message | filterA | filterB }}`。
*   **参数：** 过滤器本质上是 JavaScript 函数，可以接收参数：`{{ message | filterA('arg1', arg2) }}`。

### 5. 缩写 (Syntactic Sugar)
为了简化代码，Vue 为最常用的两个指令提供了特殊缩写。

*   **v-bind 缩写**
    *   完整语法：`<a v-bind:href="url"></a>`
    *   **缩写：** `<a :href="url"></a>`

*   **v-on 缩写**
    *   完整语法：`<a v-on:click="doSomething"></a>`
    *   **缩写：** `<a @click="doSomething"></a>`

**总结：**
Vue 的模板语法核心在于**声明式**。你不需要手动操作 DOM（如 `document.getElementById().innerHTML = ...`），只需要声明“数据”和“视图”的关系（通过 `{{ }}`、`v-bind`、`v-model` 等），Vue 会自动在数据变化时高效地更新 DOM。


