
<script setup>
import { useRoute } from "vue-router";
import { useBlogStore } from '../stores/blog';
import { watchEffect, ref } from "vue";

const { postBlog, postHandler } = useBlogStore();

const handler = () => {
    postHandler(postBlog);
}
</script>

<template>
    <div class="blogContainer">
        <div class="titleContainer">
            <input v-model="postBlog.title" placeholder="포켓몬 이름" class="" />
        </div>
        <div class="content">
            <div>
                <textarea v-model="postBlog.content" placeholder="포켓몬 설명" ></textarea>
            </div>
            <div class="imgContainer">
                <div>
                    <label> 이미지 url </label>
                    <input class="imgInput" placeholder="포켓몬 이미지 url"  v-model="postBlog.img" />
                </div>
                <template v-if="postBlog.img">
                    <img class="imgBox" :src="postBlog.img" />
                </template>
            </div>
        </div>
        <button @click="handler">등록하기 </button>
    </div>
</template>

<style scoped>
@font-face {
    font-family: 'Danjo-bold-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-1@1.1/Danjo-bold-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

input {
    font-family: 'Danjo-bold-Regular';
    font-size: 1em;
    margin-bottom: 20px;
}

button {
    height: 40px;
    margin-right: 20px;
    font-family: 'Danjo-bold-Regular';
    font-size: 1.2em;
    color: #E1DCD9;
    background-color: #a67f78;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
    line-height: 40px;
}
button:active {
    transform: translateY(2px);
}

label {
    font-family: 'Danjo-bold-Regular';
    color: #a67f78;
}

.blogContainer {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100%;
    width: 70%;
    background-color: #fff;
    margin-left: auto;
    margin-right: auto;
    border-radius: 10px;
    padding: 20px;
    margin: 20px;
    box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}

.titleContainer {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    margin-top: 3%;
    margin-bottom: 2%;
    margin-left: auto;
    margin-right: auto;
}

.title {
    width: 40%;

    text-align: center;
    border-bottom: 1px solid;
}

.contentContainer {
    text-align: center;
    width: 70%;
}

.content {
    text-align: left;
    margin-bottom: 2%;
    border: 1px;
}

textarea {
    width: 100%;
    height: 200px;
    font-family: 'Danjo-bold-Regular';
}

.imgInput {
    width: 65%;
}

.imgBox {
    width: 300px;
    height: 300px;
}

.imgContainer {
    display: flex;
    flex-direction: column;
}
</style>
