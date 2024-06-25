<script setup>
import { useRoute } from 'vue-router';
import { useBlogStore } from '@/stores/blog'
import { watchEffect, ref } from 'vue';

const route = useRoute();
const blogStroe = useBlogStore();
const modify = ref(true);

watchEffect(() => {
    blogStroe.detailsHandler(route.params.id);
});

const handler = () => {
    blogStroe.modifyHandler({id : route.params.id, ...blogStroe.detailsBlog.value })
}
const deleteMethod = () =>{
    blogStroe.deleteHandler(route.params.id);
}

</script>

<template>
    <div class="blogContainer">
        <div class="titleContainer">
            <h1 class="title" v-if="modify"> {{ blogStroe.detailsBlog.value?.title }}</h1>
            <input v-else v-model="blogStroe.detailsBlog.value.title"/>
            <div v-if="modify">
                <button @click="() => modify = false">수정</button>
                <button @click="deleteMethod">삭제</button>
            </div>
            <div v-else>
                <button @click="handler">완료</button>
                <button @click="() => modify = true">취소</button>
            </div>
        </div>

        <div class="contentContainer" v-if="modify">
            <div class="content">
                {{ blogStroe.detailsBlog.value?.content }}
            </div>
            <div>
                <img class="imgBox" :src="blogStroe.detailsBlog.value?.img" :alt="blogStroe.detailsBlog.value?.title" />
            </div>
        </div>
        <div class="content" v-else>
            <div>
                <textarea v-model="blogStroe.detailsBlog.value.content" ></textarea>
            </div>
            <div class="imgContainer">
                <div>
                    <label> 이미지 url </label>
                    <input class="imgInput" v-model="blogStroe.detailsBlog.value.img" />
                </div>
                <img class="imgBox" :src="blogStroe.detailsBlog.value.img" :alt="blogStroe.detailsBlog.value.title" />
            </div>
        </div>

    </div>
</template>

<style scoped>
@font-face {
    font-family: 'Danjo-bold-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-1@1.1/Danjo-bold-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

button {
    margin-right: 20px;
    font-family: 'Danjo-bold-Regular';
    font-size: 1.2em;
    color: #E1DCD9;
    background-color: #a67f78;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}
button:active {
    transform: translateY(2px);
}

label {
    font-family: 'Danjo-bold-Regular';
    color: #a67f78;
}

input {
    font-family: 'Danjo-bold-Regular';
    font-size: 1em;
    margin-bottom: 20px;
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
    flex-direction: column;
    width: 100%;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 30px;
}

.title {
    width: 40%;
    font-family: 'Danjo-bold-Regular';
    font-size: 2em;
    text-align: center;
    border-bottom: 1px solid;
    margin-bottom: 20px;
}

.contentContainer {
    text-align: center;
    width: 70%;
}

.content {
    font-family: 'Danjo-bold-Regular';
    text-align: left;
    margin-bottom: 30px;
    border: 1px;
}

textarea {
    width: 100%;
    height: 200px;
    font-family: 'Danjo-bold-Regular';
}

.imgInput {
    width: 65%;
    font-family: 'Danjo-bold-Regular';
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