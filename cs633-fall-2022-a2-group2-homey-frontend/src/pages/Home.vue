<template>
<div>
  <AdvCarousel :adv-list="advList"/>
  <FeaturedPro :featured-list="featuredList"/>
  <LatestPro :latest-list="latestList" :featured-list="featuredList" :trending-list="trendingList" :side-list="sideList"/>
  <HomeyOffer :homey-offers="homeyOffers"/>
  <UniquePro :unique-product="uniqueProduct"/>
  <TrendingPro :trending-list="trendingList" :trend-card1="trendCard1" :trend-card2="trendCard2" :side-list="sideList"/>
</div>
</template>

<script>
import AdvCarousel from "@/components/common/AdvCarousel";
import FeaturedPro from "@/components/Home/FeaturedPro";
import LatestPro from "@/components/Home/LatestPro";
import HomeyOffer from "@/components/Home/HomeyOffer";
import UniquePro from "@/components/Home/UniquePro";
import TrendingPro from "@/components/Home/TrendingPro";
export default {
  name: "Home",
  components: {TrendingPro, UniquePro, HomeyOffer, LatestPro, FeaturedPro, AdvCarousel},
  data(){
    return {
      advList:[
        require('../assets/advImage1.png'),
        require('../assets/advImage2.png'),
        require('../assets/advImage3.png'),
        require('../assets/advImage4.png')
      ],
      featuredList:[
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: 42.00,
          code: 'Y523201'
        }
      ],
      latestList:[
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          original_price: 65.00,
          price: 42.00
        }
      ],
      homeyOffers:[
        {
          image: require('../assets/homeyOffer1.png')
        },
        {
          image: require('../assets/homeyOffer2.png')
        },
        {
          image: require('../assets/homeyOffer3.png')
        },
        {
          image: require('../assets/homeyOffer4.png')
        }
      ],
      uniqueProduct: {
        id: 2,
        image: require('../assets/uniqueProduct.png'),
        details: [
          'All frames constructed with hardwood solids and laminates',
          'Reinforced with wood dowels, glue, screw-nails corner blocks and machine nails',
          'Arms, backs and seats are structurally reinforced'
        ],
        name: 'B&B Italian Sofa',
        price: '$32'
      },
      trendingList: [
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: 42.00,
          original_price: 65.00
        }
      ],
      trendCard1: require('../assets/trendCard1.png'),
      trendCard2: require('../assets/trendCard2.png'),
      sideList: [
        {
          image: require('../assets/trendImage.png'),
          name: 'Executive Seat Chair',
          original_price: 32.00
        }
      ],
    }
  },
  created(){
    axios.get(this.httpURL + '/product/findAll').then((resp)=>{
      let featuredList = [];
      let latestList = [];
      let trendingList = [];
      let sideList = [];
      resp.data.forEach(item => {
        if(item.type === 1){
          featuredList.push(item);
        }else if(item.type === 2){
          latestList.push(item);
        }else if(item.type === 3){
          trendingList.push(item);
        }else if(item.type === 4){
          sideList.push(item);
        }
      })
      this.featuredList = featuredList;
      this.latestList = latestList;
      this.trendingList = trendingList;
      this.sideList = sideList;
    })
  }
}
</script>