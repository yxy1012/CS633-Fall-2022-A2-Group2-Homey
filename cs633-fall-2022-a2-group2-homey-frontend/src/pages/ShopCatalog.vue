<template>
  <div>
    <el-image :src="shopCatalog"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0;">All Items</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About {{ number }} results</p>
        </el-col>
        <el-col :span="6"><div class="grid-content"></div></el-col>
        <el-col :span="1" style="padding-top: 0.5%">Sort By:</el-col>
        <el-col :span="2">
          <el-select v-model="sortBy" placeholder="Best Match" @change="changeCatalog">
            <el-option v-for="(item, index) in sortTypes" :key="index" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-col>
      </el-row>
    </div>
    <div class="featuredItems">
      <el-row>
        <el-col :span="5" v-for="(item, index) in list" :key="index" class="featuredItem">
          <router-link :to="{path: '/productDetails', query: {id: item.id}}" style="text-decoration: none; color: #000000">
            <el-image :src="item.image" style="height: 200px; width: 85%"></el-image>
            <h4 style="margin: 0">{{ item.name }}</h4>
            <el-row>
              <el-col :span="6"><div class="grid-content"></div></el-col>
              <el-col :span="6">{{ item.price | priceFilter}}</el-col>
              <el-col :span="6">
                <div style="color: red; text-decoration: line-through">{{ item.original_price | priceFilter }}</div>
              </el-col>
            </el-row>
          </router-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShopCatalog",
  data(){
    return{
      shopCatalog: require('@/assets/shopCatalog.png'),
      list:[
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          original_price: 42.00,
          price: 26.00
        }
      ],
      featuredList:[
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          original_price: 42.00,
          price: 26.00
        }
      ],
      trendingList:[
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          original_price: 42.00,
          price: 26.00
        }
      ],
      allItems:[
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          original_price: 42.00,
          price: 26.00
        }
      ],
      sortBy: '',
      number: 0,
      sortTypes:[
        {label: 'All Items', value: 'allItems'},
        {label: 'Featured Items', value: 'featuredList'},
        {label: 'Latest Items', value: 'latestList'},
        {label: 'Trending Items', value: 'trendingList'}
      ]
    }
  },
  created () {
    axios.get(this.httpURL + '/product/findAll').then((resp)=>{
      let allItems = [];
      let featuredList = [];
      let latestList = [];
      let trendingList = [];
      resp.data.forEach(item=>{
        allItems.push(item);
        if(item.type === 1){
          featuredList.push(item);
        }else if(item.type === 2){
          latestList.push(item);
        }else if(item.type === 3){
          trendingList.push(item);
        }
      })
      this.list = allItems;
      this.allItems = allItems;
      this.featuredList = featuredList;
      this.latestList = latestList;
      this.trendingList = trendingList;
      this.number = allItems.length;
    })
  },
  methods: {
    changeCatalog(){
      if(this.sortBy === "allItems"){
        this.list = this.allItems;
        this.title = "All Items";
      } else if(this.sortBy === "featuredList"){
        this.list = this.featuredList;
        this.title = "Featured Items";
      }else if(this.sortBy === "latestList"){
        this.list = this.latestList;
        this.title = "Latest Items";
      }else if(this.sortBy === "trendingList"){
        this.list = this.trendingList;
        this.title = "Trending Items";
      }
      this.number = this.list.length
    }
  }
}
</script>

<style scoped>
.title{
  padding-top: 5%;
}
.featuredItems{
  margin-top: 5%;
  margin-left: 17%;
  margin-bottom: 5%;
}
.featuredItem{
  margin-bottom: 3%;
}
</style>