<template>
<div>
  <AdvCarousel :adv-list="advList"></AdvCarousel>
  <FeaturedPro :featured-list="featuredList"></FeaturedPro>
  <LatestPro :latest-list="latestList"></LatestPro>
  <HomeyOffer :homey-offers="homeyOffers"></HomeyOffer>
  <UniquePro :unique-product="uniqueProduct"></UniquePro>
  <TrendingPro :trending-list="trendingList" :trend-card1="trendCard1" :trend-card2="trendCard2" :side-list="sideList"></TrendingPro>
  <Brands></Brands>
</div>
</template>

<script>
import AdvCarousel from "@/components/common/AdvCarousel";
import FeaturedPro from "@/components/Home/FeaturedPro";
import LatestPro from "@/components/Home/LatestPro";
import HomeyOffer from "@/components/Home/HomeyOffer";
import UniquePro from "@/components/Home/UniquePro";
import TrendingPro from "@/components/Home/TrendingPro";
import Brands from "@/components/common/Brands";
export default {
  name: "Home",
  components: {Brands, TrendingPro, UniquePro, HomeyOffer, LatestPro, FeaturedPro, AdvCarousel},
  data(){
    return {
      advList:[
        require('../assets/advImage1.png'),
        require('../assets/advImage1.png'),
        require('../assets/advImage1.png'),
        require('../assets/advImage1.png')
      ],
      featuredList:[
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          id: 'Code - Y523201'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          id: 'Code - Y523201'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          id: 'Code - Y523201'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          id: 'Code - Y523201'
        }
      ],
      latestList:[
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
        },
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
        },
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
        },
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
        },
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
        },
        {
          image: require('../assets/latestImage1.png'),
          name: 'Comfort Handy Craft',
          originalPrice: '$65.00',
          price: '$42.00'
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
          price: '$42.00',
          originalPrice: '$65'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          originalPrice: '$65'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          originalPrice: '$65'
        },
        {
          image: require('../assets/featured1.png'),
          name: 'Cantilever chair',
          price: '$42.00',
          originalPrice: '$65'
        }
      ],
      trendCard1: require('../assets/trendCard1.png'),
      trendCard2: require('../assets/trendCard2.png'),
      sideList: [
        {
          image: require('../assets/trendImage.png'),
          name: 'Executive Seat Chair',
          originalPrice: '$32'
        },
        {
          image: require('../assets/trendImage.png'),
          name: 'Executive Seat Chair',
          originalPrice: '$32'
        },
        {
          image: require('../assets/trendImage.png'),
          name: 'Executive Seat Chair',
          originalPrice: '$32'
        }
      ],
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

</style>