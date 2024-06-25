<script setup>
import BlogItem from "./PostView.vue";
import {useBlogStore} from "../../stores/blog";
import {onMounted, provide} from "vue";

const blogStore = useBlogStore();

onMounted(()=>{
    blogStore.blogHandler();
})
</script>

<template>
    <div class="homeCon">
        <div v-for="blog in blogStore.blogs" class="listBox">
            <BlogItem :key="blog.id" :blog="blog" class="listItems"></BlogItem>
        </div>
    </div>

</template>

<style scoped>
.homeCon {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    width: 100%;
}

.listBox{
    height: auto;
    width: 100%;
}
.listItems {
    background-color: #E1DCD9;
}
</style>