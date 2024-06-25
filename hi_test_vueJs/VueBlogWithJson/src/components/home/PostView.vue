<script setup>
    import { useRouter } from "vue-router";

    const router = useRouter();
    const {blog} = defineProps(["blog"]);

    function detailView(id) {
        router.push(`/blogs/${id}`);
    }
</script>

<template>
    <div class="itemBox">
        <label>{{ blog.title }}</label>
        <button @click="detailView(blog.id)">조회하기</button>
    </div>
</template>

<style scoped>
@font-face {
    font-family: 'Danjo-bold-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-1@1.1/Danjo-bold-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

.itemBox {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    margin-bottom: 1%;
    box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
    border-radius: 10px;
}

label {
    margin-left: 1%;
    font-size: 1.2em;
    color: #32435F;
    font-family: 'Danjo-bold-Regular';
    margin-left: 20px;
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
</style>